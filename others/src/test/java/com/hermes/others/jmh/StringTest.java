package com.hermes.others.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/26
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 5)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringTest {

    @Param(value = {"10", "50", "100"})
    private int length;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringTest.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void testStringAdd(Blackhole blackhole) {
        String a = "";
        for (int i = 0; i < length; i++) {
            a += i;
        }
        blackhole.consume(a);
    }

    @Benchmark
    public void testStringBuilderAdd(Blackhole blackhole) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(i);
        }
        blackhole.consume(sb.toString());
    }
}
