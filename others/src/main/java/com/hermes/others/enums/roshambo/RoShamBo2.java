package com.hermes.others.enums.roshambo;

/**
 * @author liu.zongbin
 * @since 2022/11/29
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {

    PAPER(Outcome.DRAW, Outcome.LOSE, Outcome.WIN),
    SCISSORS(Outcome.WIN, Outcome.DRAW, Outcome.LOSE),
    ROCK(Outcome.LOSE, Outcome.WIN, Outcome.DRAW);

    private Outcome vPaper, vScissors, vRock;

    RoShamBo2(Outcome vPaper, Outcome vScissors, Outcome vRock) {
        this.vPaper = vPaper;
        this.vScissors = vScissors;
        this.vRock = vRock;
    }

    @Override
    public Outcome compete(RoShamBo2 it) {
        return switch (it) {
            case PAPER -> vPaper;
            case SCISSORS -> vScissors;
            case ROCK -> vRock;
        };
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
