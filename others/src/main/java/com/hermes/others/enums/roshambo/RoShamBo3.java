package com.hermes.others.enums.roshambo;

/**
 * @author liu.zongbin
 * @since 2022/11/29
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo3 it) {
            return switch (it) {
                case PAPER -> Outcome.DRAW;
                case SCISSORS -> Outcome.LOSE;
                case ROCK -> Outcome.WIN;
            };
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 it) {
            return switch (it) {
                case PAPER -> Outcome.WIN;
                case SCISSORS -> Outcome.DRAW;
                case ROCK -> Outcome.LOSE;
            };
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 it) {
            return switch (it) {
                case PAPER -> Outcome.LOSE;
                case SCISSORS -> Outcome.WIN;
                case ROCK -> Outcome.DRAW;
            };
        }
    };

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
