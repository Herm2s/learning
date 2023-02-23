package com.hermes.spring3;

import com.hermes.spring3.config.MyBeanA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liu.zongbin
 * @since 2023/2/22
 */
@SpringBootTest(classes = Spring3Application.class)
class ProfileTest {

    @Autowired
//    @Qualifier("myBeanB")
    private MyBeanA myBeanA;

    @Test
    void test() {
        Assertions.assertNotNull(myBeanA);
    }
}
