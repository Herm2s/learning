package com.hermes.designpattern.build;

/**
 * @author liu.zongbin
 * @since 2022/8/15 22:14
 */
public class Client {

    public static void main(String[] args) {
        HouseDirector director = new HouseDirector(new CommonHouse());
        House house = director.constructHouse();
        System.out.println(house);
    }
}
