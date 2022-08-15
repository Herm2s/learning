package com.hermes.designpattern.build.common;

/**
 * @author liu.zongbin
 * @since 2022/8/15 21:50
 */
public class CommonHouse extends AbstractHouse {

    @Override
    protected void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    protected void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    protected void buildRoof() {
        System.out.println("普通房子封顶");
    }
}
