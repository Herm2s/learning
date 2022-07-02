package com.hermes.spring.service.impl;

import com.hermes.spring.service.CalcService;
import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @created 2022/6/30 13:20
 */
@Service
public class CalcServiceImpl implements CalcService {

    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("=========>CalcServiceImpl被调用了,我们的计算结果：" + result);
        return result;
    }
}
