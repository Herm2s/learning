package com.hermes.algorithm.hashtable;

/**
 * @author liu.zongbin
 * @since 2022/10/11
 */
public class Question1790 {

    public static void main(String[] args) {
        Question1790 question1790 = new Question1790();
        System.out.println(question1790.areAlmostEqual("c", "q"));
    }

    /**
     * 如果两个字符串相等，则不需要进行交换即可满足相等；
     * 如果两个字符串不相等，字符串一定存在两个位置i, j处的字符不相等，且满足s1[i] = s2[j], s1[j] = s2[i]
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] indexes = new int[2];
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index + 1 == 3) {
                    return false;
                }
                indexes[index++] = i;
            }
        }
        return index == 2
                && s1.charAt(indexes[0]) == s2.charAt(indexes[1])
                && s1.charAt(indexes[1]) == s2.charAt(indexes[0]);
    }
}
