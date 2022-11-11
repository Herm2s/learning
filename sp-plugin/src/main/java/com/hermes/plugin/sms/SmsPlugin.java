package com.hermes.plugin.sms;

import org.springframework.plugin.core.Plugin;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
public interface SmsPlugin extends Plugin<SmsEnum> {

    void sendSms(String phone, String content);
}
