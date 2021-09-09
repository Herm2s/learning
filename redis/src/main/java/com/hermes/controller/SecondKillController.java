package com.hermes.controller;

import cn.hutool.core.util.RandomUtil;
import com.hermes.service.SecondKillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/9
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class SecondKillController {

    private final SecondKillService secondKillService;

    @GetMapping("/seckill")
    public boolean seckill(@RequestParam Integer goodId) {
        return this.secondKillService.secondKill(RandomUtil.randomInt(10000), goodId);
    }
}
