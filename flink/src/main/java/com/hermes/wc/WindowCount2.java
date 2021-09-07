package com.hermes.wc;

import com.hermes.beans.UserAmount;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * 计数窗口
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/8/7
 */
public class WindowCount2 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> inputStream =
            env.readTextFile("/Users/hermes/workspace/java/flink-learning/src/main/resources/amount.txt");
        SingleOutputStreamOperator<UserAmount> dataStream = inputStream.map(line -> {
            String[] split = line.split(",");
            return new UserAmount(new Integer(split[0]), new Integer(split[1]), new Long(split[2]));
        });
        SingleOutputStreamOperator<Double> result = dataStream.keyBy(UserAmount::getUserId)
            .countWindow(10, 2)
            .aggregate(new AggregateFunction<UserAmount, Tuple2<Integer, Integer>, Double>() {
                private static final long serialVersionUID = 4828717283484311038L;

                @Override
                public Tuple2<Integer, Integer> createAccumulator() {
                    return new Tuple2<>(0, 0);
                }

                @Override
                public Tuple2<Integer, Integer> add(UserAmount value, Tuple2<Integer, Integer> accumulator) {
                    return new Tuple2<>(value.getAmount() + accumulator.f0, accumulator.f1 + 1);
                }

                @Override
                public Double getResult(Tuple2<Integer, Integer> accumulator) {
                    return (double)(accumulator.f0 / accumulator.f1);
                }

                @Override
                public Tuple2<Integer, Integer> merge(Tuple2<Integer, Integer> a, Tuple2<Integer, Integer> b) {
                    return new Tuple2<>(a.f0 + b.f0, a.f1 + b.f1);
                }
            });
        result.print();
        env.execute();
    }
}
