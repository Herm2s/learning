package com.hermes.plugin.sms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
@Getter
@RequiredArgsConstructor
public enum SmsEnum {

    ALI("阿里短信"),

    TENCENT("腾讯短信");

    private final String name;
}
