package com.hermes.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 901. 股票价格跨度
 *
 * @author liu.zongbin
 * @since 2022/10/21
 */
public class StockSpanner {

    private Deque<Integer> stack = new LinkedList<>();

    public StockSpanner() {

    }

    /**
     * 100 80
     */
    public int next(int price) {
        stack.push(price);
        int num = 0;
        for (Integer p : stack) {
            if (p <= price) {
                num++;
            } else {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
