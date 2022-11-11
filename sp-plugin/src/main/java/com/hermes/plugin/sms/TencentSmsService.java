package com.hermes.plugin.sms;

import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
@Service
public class TencentSmsService implements SmsPlugin {

    @Override
    public void sendSms(String phone, String content) {
        System.out.println("发送腾讯短信，手机：" + phone + ", 内容：" + content);
    }

    @Override
    public boolean supports(SmsEnum delimiter) {
        return SmsEnum.TENCENT.equals(delimiter);
    }
}
