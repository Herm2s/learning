package com.hermes.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/8/23 21:41
 */
public class Client {

    public static void main(String[] args) {
        // 创建学院
        List<College> collegeList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        Output output = new Output(collegeList);
        output.printCollege();
    }
}
