package com.hermes.spring3;

import com.hermes.spring3.lookup.CommandConfig;
import com.hermes.spring3.lookup.CommandManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu.zongbin
 * @since 2023/2/21
 */
class CommandTest {

    @Test
    void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommandConfig.class);
        CommandManager manager1 = applicationContext.getBean(CommandManager.class);
        CommandManager manager2 = applicationContext.getBean(CommandManager.class);
        Assertions.assertEquals(manager1, manager2);

        manager1.process(1);
        manager2.process(1);
    }
}
