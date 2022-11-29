package com.hermes.others.enums.roshambo;

/**
 * @author liu.zongbin
 * @since 2022/11/29
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static final Outcome[][] TABLE = {
            // PAPER
            {Outcome.DRAW, Outcome.LOSE, Outcome.WIN},
            // SCISSORS
            {Outcome.WIN, Outcome.DRAW, Outcome.LOSE},
            // ROCK
            {Outcome.LOSE, Outcome.WIN, Outcome.DRAW}
    };

    @Override
    public Outcome compete(RoShamBo6 competitor) {
        return TABLE[this.ordinal()][competitor.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
