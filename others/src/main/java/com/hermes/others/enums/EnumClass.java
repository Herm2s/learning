package com.hermes.others.enums;

/**
 * @author liu.zongbin
 * @since 2022/11/22
 */
enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("----------------");
        }
        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            Shrubbery shrubbery1 = Shrubbery.valueOf(s);
            System.out.println(shrubbery);
            System.out.println(shrubbery1);
        }
        for (Shrubbery shrubbery : Shrubbery.class.getEnumConstants()) {
            System.out.println(shrubbery.name());
        }
    }
}
