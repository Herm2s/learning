package com.hermes.designpattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:48
 */
public class ConcreteMediator extends Mediator {

    private Map<String, Colleague> colleagueMap;
    private Map<String, String> interMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap<>();
        this.interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        this.colleagueMap.put(colleagueName, colleague);
        if (colleague instanceof Alarm) {
            this.interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof CoffeeMachine) {
            this.interMap.put("CoffeeMachine", colleagueName);
        } else if (colleague instanceof TV) {
            this.interMap.put("TV", colleagueName);
        } else if (colleague instanceof Curtains) {
            this.interMap.put("Curtains", colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        Colleague colleague = this.colleagueMap.get(colleagueName);

        if (colleague instanceof Alarm) {
            if (stateChange == 0) {
                CoffeeMachine coffeeMachine = (CoffeeMachine) this.colleagueMap.get("CoffeeMachine");
                coffeeMachine.startCoffee();

                TV tv = (TV) this.colleagueMap.get(interMap.get("TV"));
                tv.startTV();
            } else if (stateChange == 1) {
                TV tv = (TV) this.colleagueMap.get(interMap.get("TV"));
                tv.closeTV();
            }

        } else if (colleague instanceof CoffeeMachine) {
            Curtains curtains = (Curtains) this.colleagueMap.get("Curtains");
            curtains.upCurtains();

        } else if (colleague instanceof TV) {

        } else if (colleague instanceof Curtains) {

        }
    }

    @Override
    public void sendMessage() {

    }
}
