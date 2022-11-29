package com.hermes.others.enums.roshambo;

/**
 * @author liu.zongbin
 * @since 2022/11/29
 */
public interface Competitor<T extends Competitor<T>> {

    Outcome compete(T competitor);
}
