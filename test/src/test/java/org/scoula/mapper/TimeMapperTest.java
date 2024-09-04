package org.scoula.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 오류 해결
// TimeMapper.xml의 select sysdate가 getTime2()에 2개 걸려있었음. 근데 없애줘도 괜찮음.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j
class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    @DisplayName("TimeMapper의 getTime()")
    public void getTime() {
        //구현체가 어떤 것이지 알 수 있는 코드
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

    @Test
    @DisplayName("TimeMapper의 getTime2()")
    public void getTime2() {
        //구현체가 어떤 것이지 알 수 있는 코드
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}