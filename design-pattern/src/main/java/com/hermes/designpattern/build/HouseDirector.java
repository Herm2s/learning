package com.hermes.designpattern.build;

/**
 * @author liu.zongbin
 * @since 2022/8/15 22:20
 */
public class HouseDirector {

    private final HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.buildRoof();
        return houseBuilder.buildHouse();
    }
}
