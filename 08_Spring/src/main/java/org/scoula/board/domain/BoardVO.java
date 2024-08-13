package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
    // updateDate -> update_date
    // mybatis-config에서 mapUnderScoreToCamelCase 때문에 알아서 _로 이름이 바뀜
    // sql에는 컬럼명이 카멜케이스임 !
}
