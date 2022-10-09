import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFutureTest1 {

    StopWatch sw = new StopWatch();

    @Test
    public void test1() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        sw.start();
        CompletableFuture.supplyAsync(() -> {
                    String result = "test1";
                    System.out.println(result);
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return result;
                }, executor)
                .thenAccept(System.out::println);
        sw.stop();
        System.out.println(sw.shortSummary(TimeUnit.MILLISECONDS));
    }

    @Test
    public void test2() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture.completedFuture("test2")
                .thenAccept(System.out::println);
    }

    @Test
    public void test3() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture.completedFuture("test2")
                .thenAccept(System.out::println);
    }

}

