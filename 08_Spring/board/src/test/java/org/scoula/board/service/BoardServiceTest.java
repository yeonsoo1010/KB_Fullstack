package org.scoula.board.service;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class} )
@Log4j
public class BoardServiceTest {

    @Autowired
    // 업캐스팅 board service 하위에 해당하는 타입을 찾아서 해당 객체를 주입한다.
    // 실체화된 애를 의존성으로 주입. bean으로 등록하려면
    // 상위타입 중에 boardService가 있음. 얘를 등록함.
    // service 객체는 boardservice 타입을 가진 빈을 자동으로 주입 -- 타입 기반 autowired
    // 타입 중에 상위 타입도 업캐스팅 가능함.

    //Spring은 @Autowired를 통해 주입할 때, 주로 인터페이스 타입의 변수를 사용하고,
    // 해당 인터페이스를 구현한 클래스를 찾아 주입합니다.
    // 이 과정에서 실제 주입되는 객체는 BoardServiceImpl 클래스의 인스턴스입니다.
    // 그러나 코드는 BoardService 인터페이스를 통해 이 객체를 사용하게 됩니다.
    private BoardService service;

    @Test
    void getList() {
        for(BoardDTO board: service.getList()) {
            log.info(board);
        }
    }

    @Test
    void get() {
        log.info(service.get(1L));
    }

    @Test
    void create() {
        BoardDTO board = new BoardDTO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user1");

        service.create(board);

        log.info("생성된 게시물의 번호: " + board.getNo());

    }

    @Test
    public void update() {
        BoardDTO board = service.get(1L);
        board.setTitle("제목 수정합니다.");
        log.info("update RESULT: " + service.update(board));
    }

    @Test
    public void delete() {
        // 게시물 번호의 존재 여부를 확인하고 테스트할 것
        log.info("delete RESULT: " + service.delete(2L));
    }
}