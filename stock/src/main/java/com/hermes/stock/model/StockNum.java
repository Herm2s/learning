package com.hermes.stock.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author liu.zongbin
 * @since 2023/2/6
 */
@Data
public class StockNum implements Serializable {

    @Serial
    private static final long serialVersionUID = -3267058689688138368L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer num;
}
