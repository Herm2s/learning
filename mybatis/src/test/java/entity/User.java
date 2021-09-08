package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/7
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3849966625037251655L;

    private Integer userId;

    private String username;
}
