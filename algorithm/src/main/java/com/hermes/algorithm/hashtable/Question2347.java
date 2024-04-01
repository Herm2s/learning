package com.hermes.algorithm.hashtable;

import java.util.Arrays;
import java.util.List;

/**
 * @author liu.zongbin
 * @date 2024/3/29
 */
public class Question2347 {

    public static String bestHand(int[] ranks, char[] suits) {
        int[] suitArr = new int[4];
        for (char suit : suits) {
            suitArr[suit - 'a']++;
        }
        int[] rankArr = new int[13];
        for (int rank : ranks) {
            rankArr[rank - 1]++;
        }

        for (int suitCount : suitArr) {
            if (suitCount == 5) {
                return "Flush";
            }
        }
        int three = 0;
        int pair = 0;
        for (Integer rankCount : rankArr) {
            if (rankCount >= 3) {
                three = 1;
                break;
            }
            if (rankCount == 2) {
                pair = 1;
            }
        }
        return three == 1 ? "Three of a Kind" : pair == 1 ? "Pair" : "High Card";
    }

    public static String bestHand1(int[] ranks, char[] suits) {
        int[] suitArr = new int[4];
        int[] rankArr = new int[13];

        int ans = 0;
        List<String> results = Arrays.asList(
                "High Card",
                "Pair",
                "Three of a Kind",
                "Flush"
        );

        for (int i = 0; i < ranks.length; i++) {
            rankArr[ranks[i] - 1]++;
            suitArr[suits[i] - 'a']++;

            if (suitArr[suits[i] - 'a'] == 5) {
                ans = Math.max(ans, 3);
            } else if (rankArr[ranks[i] - 1] == 3) {
                ans = Math.max(ans, 2);
            } else if (rankArr[ranks[i] - 1] == 2) {
                ans = Math.max(ans, 1);
            }
        }
        return results.get(ans);
    }

    public static void main(String[] args) {
        int[] ranks = new int[]{12, 12, 12, 9, 9};
        // char[] suits = new char[]{'d', 'a', 'a', 'b', 'c'};
        char[] suits = new char[]{'b', 'd', 'a', 'b', 'c'};
        System.out.println(bestHand(ranks, suits));
    }
}
