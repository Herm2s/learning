package com.hermes.distributed.lock.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:48
 */
@TableName("stock")
@Data
public class Stock {

    @TableId
    private Long id;

    private String productCode;

    private String warehouse;

    private Integer stock;
}
