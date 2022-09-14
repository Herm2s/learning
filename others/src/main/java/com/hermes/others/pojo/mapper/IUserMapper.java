package com.hermes.others.pojo.mapper;

import com.hermes.others.pojo.entity.UserEntity;
import com.hermes.others.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liu.zongbin
 * @since 2022/9/13
 */
@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    //    @Mappings(value = {
//            @Mapping(source = "userNick1", target = "userNick"),
//            @Mapping(source = "age", target = "age", numberFormat = "#0.00"),
//            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "userVerified", defaultValue = "defaultValue-2")
//    })
    UserEntity vo2Entity(UserVO userVO);

}
