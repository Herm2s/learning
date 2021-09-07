package com.hermes.wc;

import com.ververica.cdc.connectors.mysql.MySqlSource;
import com.ververica.cdc.debezium.StringDebeziumDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.SqlDialect;
import org.apache.flink.table.api.StatementSet;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableResult;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/8/18
 */
public class AttendanceInfoJob {

    //    @PostConstruct
    public static void main(String[] args) {

        SourceFunction<String> sourceFunction = MySqlSource.<String>builder()
            .hostname("10.123.90.43")
            .port(3307)
            .databaseList("pigxx_uat") // monitor all tables under inventory database
            .username("bigdatarepl")
            .password("bigdata@uat@Manager@123")
            .tableList("pigxx_uat.bigdata_test")
            .deserializer(new StringDebeziumDeserializationSchema()) // converts SourceRecord to String
            .build();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.enableCheckpointing(200);
        StreamTableEnvironment tableEnv =
            StreamTableEnvironment.create(
                env,
                EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build());
        tableEnv.getConfig().setSqlDialect(SqlDialect.DEFAULT);
        tableEnv.executeSql("CREATE TABLE cdc_mysql_binlog (\n" +
            " id INT NOT NULL,\n" +
            " name STRING,\n" +
            " a_b STRING,\n" +
            " primary key (`id`) not enforced\n" +
            ") WITH (\n" +
            " 'connector' = 'mysql-cdc',\n" +
            " 'hostname' = '10.123.90.43',\n" +
            " 'port' = '3307',\n" +
            " 'username' = 'bigdatarepl',\n" +
            " 'password' = 'bigdata@uat@Manager@123',\n" +
            " 'database-name' = 'pigxx_uat',\n" +
            " 'table-name' = 'bigdata_test'\n" +
            ")");
        tableEnv.executeSql("CREATE TABLE cdc_2_mysql_result (\n" +
            " id INT PRIMARY KEY,\n" +
            " name STRING,\n" +
            " a_b STRING\n" +
            ") WITH (\n" +
            " 'connector' = 'jdbc',\n" +
            " 'url' = 'jdbc:mysql://10.123.90.43:3307/pigxx_uat',\n" +
            " 'table-name' = 'bigdata_test',\n" +
            " 'username' = 'ykt',\n" +
            " 'password' = 'ykt@Manager@1@#'\n" +
            ")");
        Table table = tableEnv.sqlQuery("select * from cdc_mysql_binlog");

        DataStream<Row> dataStream = tableEnv.toChangelogStream(table);

        env.addSource(sourceFunction).print("MysqlSource").setParallelism(1);

        dataStream.print("Table").setParallelism(1);

        StatementSet statementSet = tableEnv.createStatementSet();
        statementSet.addInsertSql("INSERT INTO cdc_2_mysql_result " +
            "SELECT \n" +
            " id \n" +
            ",name\n" +
            ",a_b\n" +
            " FROM cdc_mysql_binlog");
        final TableResult execute = statementSet.execute();
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
