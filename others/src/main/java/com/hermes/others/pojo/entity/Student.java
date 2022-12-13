package com.hermes.others.pojo.entity;

/**
 * @author liu.zongbin
 * @since 2022/12/12
 */
public record Student(String name) {

    public static void main(String[] args) {
        Student student = new Student("小明");
    }
}
