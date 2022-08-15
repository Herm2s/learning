package com.hermes.designpattern.build;

/**
 * @author liu.zongbin
 * @since 2022/8/15 22:15
 */
public abstract class HouseBuilder {

    protected House house = new House();

    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWall();

    /**
     * 封顶
     */
    public abstract void buildRoof();

    public House buildHouse() {
        return house;
    }
}
