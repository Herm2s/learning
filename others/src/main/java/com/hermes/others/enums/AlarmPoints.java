package com.hermes.others.enums;

/**
 * @author liu.zongbin
 * @since 2022/11/28
 */
public enum AlarmPoints {

    START1, START2, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY, KITCHEN;

    interface Command {
        void action();
    }
}