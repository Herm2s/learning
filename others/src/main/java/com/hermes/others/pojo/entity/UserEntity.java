package com.hermes.others.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author liu.zongbin
 * @since 2022/9/13
 */
@Data
public class UserEntity {

    private Long id;
    private Date gmtCreate;
    private Date createTime;
    private Long buyerId;
    private Long age;
    private String userNick;
    private String userVerified;
}
