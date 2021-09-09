package com.hermes.service;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/9
 */
public interface SecondKillService {

    /**
     * 秒杀
     */
    boolean secondKill(Integer userId, Integer goodId);
}
