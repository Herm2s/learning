package com.hermes.others.io;

import com.hermes.others.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public final class Directory {

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File file : startDir.listFiles()) {
            if (file.isDirectory()) {
                result.dirs.add(file);
                result.addAll(recurseDirs(file, regex));
            } else {
                if (file.getName().matches(regex)) {
                    result.files.add(file);
                }
            }
        }
        return result;
    }

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {

            private final Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk(".", "T.*\\.java"));
        } else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }
}
