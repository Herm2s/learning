package com.hermes.wc;

import com.hermes.beans.UserAmount;
import org.apache.commons.collections.IteratorUtils;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * window函数全量聚合
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/8/7
 */
public class WindowCount1 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //        DataStreamSource<String> inputStream =
        //            env.readTextFile("/Users/hermes/workspace/java/flink-learning/src/main/resources/amount.txt");
        DataStreamSource<String> inputStream = env.socketTextStream("localhost", 7777);
        SingleOutputStreamOperator<UserAmount> dataStream = inputStream.map(line -> {
            String[] split = line.split(",");
            return new UserAmount(new Integer(split[0]), new Integer(split[1]), new Long(split[2]));
        });
        SingleOutputStreamOperator<Tuple3<Integer, Long, Integer>> resultStream = dataStream
            .keyBy(UserAmount::getUserId)
            .window(TumblingProcessingTimeWindows.of(Time.seconds(15L)))
            .apply(new WindowFunction<UserAmount, Tuple3<Integer, Long, Integer>, Integer, TimeWindow>() {
                private static final long serialVersionUID = 1150754297289620584L;

                @Override
                public void apply(Integer userId, TimeWindow window, Iterable<UserAmount> input,
                    Collector<Tuple3<Integer, Long, Integer>> out) {
                    Integer count = IteratorUtils.toList(input.iterator()).size();
                    out.collect(new Tuple3<>(userId, window.getEnd(), count));
                }
            });
        resultStream.print();
        env.execute();
    }
}
