package com.hermes.designpattern.build;

/**
 * @author liu.zongbin
 * @since 2022/8/15 22:20
 */
public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        house.setBasic("高楼地基");
        System.out.println("高楼地基");
    }

    @Override
    public void buildWall() {
        System.out.println("高楼砌墙");
        house.setWall("高楼墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("高楼封顶");
        house.setRoof("高楼屋顶");
    }
}
