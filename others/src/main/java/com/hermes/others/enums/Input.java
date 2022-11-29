package com.hermes.others.enums;

import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @author liu.zongbin
 * @since 2022/11/28
 */
@NoArgsConstructor
public enum Input {

    NICKEL(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100),
    TOOTHPASTE(200),
    CHIPS(75),
    SODA(100),
    SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        @Override
        int amount() {
            throw new RuntimeException("STOP.amount()");
        }
    };

    int value;

    Input(int value) {
        this.value = value;
    }

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    public static Input randomSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }
}
