package com.hermes.heima_juc.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author liu.zongbin
 * @since 2022/9/11
 */
public class WordCount {

    static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        int length = ALPHA.length();
        int count = 200;
        ArrayList<String> list = new ArrayList<>(length * count);
        for (int i = 0; i < length; i++) {
            char ch = ALPHA.charAt(i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(ch));
            }
        }
        Collections.shuffle(list);
        for (int i = 0; i < 26; i++) {
            try (PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream("tmp/" + (i + 1) + ".txt")))) {
                String str = String.join("\n", list.subList(i * count, (i + 1) * count));
                out.println(str);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}