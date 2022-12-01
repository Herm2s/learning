package com.hermes.others.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class DirList {

    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                private final Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dir : list) {
            System.out.println(dir);
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}