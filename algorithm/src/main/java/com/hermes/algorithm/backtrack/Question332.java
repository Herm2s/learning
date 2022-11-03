package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重新安排行程
 *
 * @author liu.zongbin
 * @since 2022/11/3
 */
public class Question332 {

    private List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        return result;
    }

    public static void main(String[] args) {
        Question332 question332 = new Question332();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(question332.findItinerary(tickets));
    }
}
