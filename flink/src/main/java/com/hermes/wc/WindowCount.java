package com.hermes.wc;

import com.hermes.beans.UserAmount;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * window函数增量聚合
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/8/7
 */
public class WindowCount {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //        DataStreamSource<String> inputStream =
        //            env.readTextFile("/Users/hermes/workspace/java/flink-learning/src/main/resources/amount.txt");
        DataStreamSource<String> inputStream = env.socketTextStream("localhost", 7777);
        SingleOutputStreamOperator<UserAmount> dataStream = inputStream.map(line -> {
            String[] split = line.split(",");
            return new UserAmount(new Integer(split[0]), new Integer(split[1]), new Long(split[2]));
        });
        SingleOutputStreamOperator<Integer> resultStream = dataStream
            .keyBy(UserAmount::getUserId)
            .window(TumblingProcessingTimeWindows.of(Time.seconds(15L)))
            .aggregate(new AggregateFunction<UserAmount, Integer, Integer>() {
                private static final long serialVersionUID = -2548038250045950344L;

                @Override
                public Integer createAccumulator() {
                    return 0;
                }

                @Override
                public Integer add(UserAmount userAmount, Integer accumulator) {
                    return accumulator + 1;
                }

                @Override
                public Integer getResult(Integer accumulator) {
                    return accumulator;
                }

                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        resultStream.print();
        env.execute();
    }
}
