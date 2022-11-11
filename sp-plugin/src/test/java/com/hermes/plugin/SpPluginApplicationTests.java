package com.hermes.plugin;

import com.hermes.plugin.order.OrderEnum;
import com.hermes.plugin.order.OrderPlugin;
import com.hermes.plugin.sms.SmsEnum;
import com.hermes.plugin.sms.SmsPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.plugin.core.PluginRegistry;

@SpringBootTest
class SpPluginApplicationTests {

    @Autowired
    private PluginRegistry<SmsPlugin, SmsEnum> pluginRegistry;

    @Autowired
    private PluginRegistry<OrderPlugin, OrderEnum> orderPluginRegistry;

    @Test
    void contextLoads() {
        SmsPlugin plugin = pluginRegistry.getRequiredPluginFor(SmsEnum.ALI);
        plugin.sendSms("111", "略略略");
        OrderPlugin plugin1 = orderPluginRegistry.getRequiredPluginFor(OrderEnum.BOX);
        plugin1.createOrder();
    }

}
