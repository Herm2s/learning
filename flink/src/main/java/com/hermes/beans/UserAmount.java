package com.hermes.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/8/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAmount implements Serializable {

    private static final long serialVersionUID = -3802504325730454640L;

    private Integer userId;

    private Integer amount;

    private Long timestamp;
}
