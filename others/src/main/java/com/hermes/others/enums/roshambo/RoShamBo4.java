package com.hermes.others.enums.roshambo;

/**
 * @author liu.zongbin
 * @since 2022/11/29
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(ROCK, competitor);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(PAPER, competitor);
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSORS, competitor);
        }
    };

    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        if (opponent == this) {
            return Outcome.DRAW;
        }
        if (opponent == loser) {
            return Outcome.WIN;
        }
        return Outcome.LOSE;
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
