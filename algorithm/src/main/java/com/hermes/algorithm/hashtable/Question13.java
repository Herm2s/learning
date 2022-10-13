package com.hermes.algorithm.hashtable;

/**
 * 罗马数字转整数
 *
 * @author liu.zongbin
 * @since 2022/10/13
 */
public class Question13 {

    public int romanToInt(String s) {
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int value = this.getValue(s.charAt(i));
            if (i < length - 1 && value < this.getValue(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public int getValue(Character symbol) {
        switch (symbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Question13 question13 = new Question13();
        System.out.println(question13.romanToInt("IX"));
    }
}
