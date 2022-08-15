package com.hermes.designpattern.build.common;

/**
 * @author liu.zongbin
 * @since 2022/8/15 21:54
 */
public class HighBuilding extends AbstractHouse {

    @Override
    protected void buildBasic() {
        System.out.println("高楼打地基");
    }

    @Override
    protected void buildWalls() {
        System.out.println("高楼砌墙");
    }

    @Override
    protected void buildRoof() {
        System.out.println("高楼封顶");
    }
}
