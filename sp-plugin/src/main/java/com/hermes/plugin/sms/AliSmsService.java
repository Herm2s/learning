package com.hermes.plugin.sms;

import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
@Service
public class AliSmsService implements SmsPlugin {

    @Override
    public void sendSms(String phone, String content) {
        System.out.println("发送阿里短信，手机：" + phone + ", 内容：" + content);
    }

    @Override
    public boolean supports(SmsEnum delimiter) {
        return SmsEnum.ALI.equals(delimiter);
    }
}
