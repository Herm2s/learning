package com.hermes.designpattern.build;

/**
 * @author liu.zongbin
 * @since 2022/8/15 22:19
 */
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
        house.setBasic("普通房子打地基");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子砌墙");
        house.setWall("普通房子墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("普通房子封顶");
        house.setRoof("普通房子屋顶");
    }
}
