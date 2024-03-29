import lombok.Getter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompletableMallTest {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("tmall"),
            new NetMall("pdd"),
            new NetMall("mi")
    );

    @Test
    public void completableMallTest() {
        long startTime = System.currentTimeMillis();
        List<String> list1 = findPriceSync(list, "thinking in java");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----同步执行: " + (endTime - startTime) + " 毫秒");

        long startTime2 = System.currentTimeMillis();
        List<String> list2 = findPriceASync(list, "thinking in java");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("----异步执行: " + (endTime2 - startTime2) + " 毫秒");
    }

    // 同步计算
    public static List<String> findPriceSync(List<NetMall> list, String productName) {
        return list.stream()
                .map(mall -> String.format(productName + " %s price is %.2f", mall.getNetMallName(), mall.getPriceByName(productName)))
                .collect(Collectors.toList());
    }

    // 异步计算
    public static List<String> findPriceASync(List<NetMall> list, String productName) {
        return list.stream()
                .map(mall -> CompletableFuture.supplyAsync(() -> String.format(productName + " %s price is %.2f", mall.getNetMallName(), mall.getPriceByName(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}

class NetMall {
    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double getPriceByName(String productName) {
        return calcPrice(productName);
    }

    private double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() + productName.charAt(0);
    }
}
