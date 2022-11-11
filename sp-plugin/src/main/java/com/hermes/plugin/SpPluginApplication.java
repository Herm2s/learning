package com.hermes.plugin;

import com.hermes.plugin.order.OrderPlugin;
import com.hermes.plugin.sms.SmsPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@EnablePluginRegistries({SmsPlugin.class, OrderPlugin.class})
@SpringBootApplication
public class SpPluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpPluginApplication.class, args);
    }

}
