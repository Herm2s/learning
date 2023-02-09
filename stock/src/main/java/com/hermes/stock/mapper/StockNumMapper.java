package com.hermes.stock.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * @author liu.zongbin
 * @since 2023/2/6
 */
public interface StockNumMapper {

    @Update(value = """
            UPDATE stock_num SET num = num - 1
            WHERE id = #{id} 
            """)
    int reduce(Long id);
}
