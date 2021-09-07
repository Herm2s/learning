package com.hermes.wc;

import com.hermes.beans.UserAmount;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.time.Duration;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/8/8
 */
public class WindowCount_EvenTimeWindow {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        DataStreamSource<String> inputStream = env.socketTextStream("127.0.0.1", 7777);
        SingleOutputStreamOperator<UserAmount> dataStream = inputStream.map(line -> {
            String[] fields = line.split(",");
            return new UserAmount(new Integer(fields[0]), new Integer(fields[1]), new Long(fields[2]));
        }).assignTimestampsAndWatermarks(WatermarkStrategy.<UserAmount>forBoundedOutOfOrderness(Duration.ofSeconds(3L))
            .withTimestampAssigner(context -> (element, recordTimestamp) -> element.getTimestamp())
        );
        env.execute();
    }
}
