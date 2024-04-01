package com.hermes.statemachine.config;

import com.hermes.statemachine.event.Events;
import com.hermes.statemachine.state.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * <a href="https://docs.spring.io/spring-statemachine/docs/3.2.1/reference/#sm-config">文档</a>
 *
 * @author liu.zongbin
 * @date 2023/8/17
 */
@Slf4j
@Configuration
@EnableStateMachine
public class StatemachineConfiguration extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true)
        // .listener(listener())
        ;
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.CREATE)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                .source(States.CREATE).target(States.PAID).event(Events.PAY).action(context -> System.out.println(context))
                .and()
                .withExternal()
                .source(States.PAID).target(States.FINISHED).event(Events.FINISH).action(context -> System.out.println(context))
                .and();
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<>() {

            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                log.info("State change to {}", to.getId());
            }
        };
    }
}
