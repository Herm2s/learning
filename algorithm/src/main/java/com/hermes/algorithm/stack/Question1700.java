package com.hermes.algorithm.stack;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/10/19
 */
public class Question1700 {

    /**
     * @param students   [1,1,0,0]
     * @param sandwiches [0,1,0,1]
     * @return int
     */
    public int countStudents(int[] students, int[] sandwiches) {
        // 喜欢方形的学生数
        int s1 = Arrays.stream(students).sum();
        // 喜欢圆形的学生数
        int s0 = students.length - s1;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && s0 > 0) {
                s0--;
            } else if (sandwich == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {
        Question1700 question1700 = new Question1700();
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int result = question1700.countStudents(students, sandwiches);
        System.out.println(result);
    }
}
