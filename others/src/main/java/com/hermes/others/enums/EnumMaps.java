package com.hermes.others.enums;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/11/28
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, AlarmPoints.Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(AlarmPoints.BATHROOM, () -> System.out.println("Bathroom fire!"));
        for (Map.Entry<AlarmPoints, AlarmPoints.Command> e : em.entrySet()) {
            System.out.println(e.getKey() + "：");
            e.getValue().action();
        }
        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
