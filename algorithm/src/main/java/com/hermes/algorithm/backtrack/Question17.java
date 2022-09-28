package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/9/28
 */
public class Question17 {

    private List<String> result = new ArrayList<>();

    private StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Question17 question17 = new Question17();
        System.out.println(question17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>(16);
        // 23, abcdef
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTracking(map, digits, 0);
        return result;
    }

    void backTracking(Map<Character, String> map, String digits, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = map.get(digits.charAt(startIndex));
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backTracking(map, digits, startIndex + 1);
            path.deleteCharAt(startIndex);
        }
    }
}
