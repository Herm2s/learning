package com.hermes.designpattern.build.common;

/**
 * @author liu.zongbin
 * @since 2022/8/15 21:47
 */
public abstract class AbstractHouse {

    /**
     * 打地基
     */
    protected abstract void buildBasic();

    /**
     * 砌墙
     */
    protected abstract void buildWalls();

    /**
     * 封顶
     */
    protected abstract void buildRoof();

    /**
     * 打地基
     */
    public void build() {
        buildBasic();
        buildWalls();
        buildRoof();
    }
}
