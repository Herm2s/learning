package com.hermes.others.util;

import org.junit.jupiter.api.Test;

import static com.hermes.others.util.MuteHelper.mute;

/**
 * @author herm2s
 * @since 2023/2/11 16:36
 */
public class MuteTest {

    private void complex() {

    }

    private void logic() {

    }

    private void here() {

    }

    @Test
    public void test() {
        mute(() -> {
            complex();
            logic();
            here();
        });
    }

}
