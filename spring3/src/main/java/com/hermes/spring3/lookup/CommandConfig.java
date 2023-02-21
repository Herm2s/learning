package com.hermes.spring3.lookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author liu.zongbin
 * @since 2023/2/21
 */
@Configuration
public class CommandConfig {

    @Bean
    @Scope("prototype")
    public AsyncCommand asyncCommand() {
        return new AsyncCommand();
    }

    @Bean
    public CommandManager commandManager() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return asyncCommand();
            }
        };
    }
}
