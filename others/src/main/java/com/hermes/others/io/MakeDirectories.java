package com.hermes.others.io;

import java.io.File;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class MakeDirectories {

    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isDirectory());
        System.out.println(file.lastModified());
    }
}
