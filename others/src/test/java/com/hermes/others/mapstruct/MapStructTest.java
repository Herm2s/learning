package com.hermes.others.mapstruct;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.hermes.others.pojo.entity.UserEntity;
import com.hermes.others.pojo.mapper.IUserMapper;
import com.hermes.others.pojo.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * @author liu.zongbin
 * @since 2022/9/13
 */
@Slf4j(topic = "MapStructTest")
class MapStructTest {

    @Test
    void testNormal() {
        log.debug("-----------testNormal-----start------");
        UserVO userVO = UserVO.builder()
                .id(1L)
                .gmtCreate(new Date())
                .buyerId(666L)
                .userNick("测试mapstruct")
                .userVerified("ok")
                .age(18L)
                .build();
        log.debug(JSONUtil.toJsonStr(userVO));
        UserEntity userEntity = IUserMapper.INSTANCE.vo2Entity(userVO);
        log.debug(JSONUtil.toJsonStr(userEntity));
        log.debug("-----------testNormal-----end------");
    }

    @Test
    void benchmark() {
        int times = 50_0000;
        StopWatch stopWatch = new StopWatch("Bean Copy");

        stopWatch.start("spring");
        for (int i = 0; i < times; i++) {
            UserVO userVO = UserVO.builder()
                    .id(1L)
                    .gmtCreate(new Date())
                    .buyerId(666L)
                    .userNick("测试123")
                    .userVerified("ok")
                    .build();
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userVO, userEntity);
        }
        stopWatch.stop();

        stopWatch.start("mapstruct");
        for (int i = 0; i < times; i++) {
            UserVO userVO = UserVO.builder()
                    .id(1L)
                    .gmtCreate(new Date())
                    .buyerId(666L)
                    .userNick("测试123")
                    .userVerified("ok")
                    .build();
            UserEntity userEntity = IUserMapper.INSTANCE.vo2Entity(userVO);
        }
        stopWatch.stop();

        stopWatch.start("hutool");
        for (int i = 0; i < times; i++) {
            UserVO userVO = UserVO.builder()
                    .id(1L)
                    .gmtCreate(new Date())
                    .buyerId(666L)
                    .userNick("测试123")
                    .userVerified("ok")
                    .build();
            UserEntity userEntity = BeanUtil.copyProperties(userVO, UserEntity.class);
        }
        stopWatch.stop();
        log.debug(stopWatch.prettyPrint());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(2 << 1);
    }
}
