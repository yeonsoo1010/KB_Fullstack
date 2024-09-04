package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("SELECT sysdate()")
    // @Select("SELECT sysdate FROM dual") -- dual이 oracle
    public String getTime();
    // 어노테이션 @select로 sql select문으로 연결함.


    // SQL문을 xml로 분리
    public String getTime2();
}
