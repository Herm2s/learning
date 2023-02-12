package com.hermes.others.util;

/**
 * @author herm2s
 * @since 2023/2/11 16:29
 */
public class MuteHelper {

    @FunctionalInterface
    interface CheckedRunnable {

        void run() throws Throwable;
    }

    public static void mute(CheckedRunnable runnable) {
        try {
            runnable.run();
        } catch (Throwable ignore) {
            // ignore.printStackTrace();
        }
    }
}
