package com.hermes.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author herm2s
 * @since 2022/10/29 20:47
 */
public class Question1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        if ("type".equals(ruleKey)) {
            index = 0;
        } else if ("color".equals(ruleKey)) {
            index = 1;
        } else if ("name".equals(ruleKey)) {
            index = 2;
        }
        int result = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question1773 question1773 = new Question1773();

        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));
        System.out.println(question1773.countMatches(items, "color", "silver"));
    }
}
