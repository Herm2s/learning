package com.hermes.others.enums.roshambo;

import java.util.Random;

/**
 * @author liu.zongbin
 * @since 2022/11/29
 */
public class RoShamBo1 {

    static final int SIZE = 20;

    private static Random rand = new Random(47);

    public static Item newItem() {
        return switch (rand.nextInt(3)) {
            case 1 -> new Paper();
            case 2 -> new Rock();
            default -> new Scissors();
        };
    }

    public static void match(Item a, Item b) {
        System.out.println(a.getClass().getSimpleName() + " vs " + b.getClass().getSimpleName() + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
