package org.scoula.board.controller;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.service.BoardService;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // Spring의 테스트 기능을 확장하여 JUnit 5에서 Spring의 컨텍스트와 관련된 기능을 사용할 수 있도록
@WebAppConfiguration // Spring MVC 테스트에서 웹 애플리케이션 컨텍스트를 설정할 때 사용됩니다.
// 보통 웹 애플리케이션의 루트 디렉토리를 설정하기 위해 사용되며, 기본적으로는 src/main/webapp 경로로 설정됩니다.
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class}) // 애플리케이션 컨텍스트 설정
// rootConfig.class, ServletConfig.class는 애플리케이션 설정을 담고 있는 클래스
@Log4j

class BoardControllerTest {
    @Autowired
    BoardService service;
    // BoardService 타입의 빈을 Spring 컨테이너에서 찾아 자동으로 주입해줍니다.

    @Autowired
    private WebApplicationContext ctx;
    // Spring MVC에서 웹 애플리케이션의 컨텍스트를 나타내는 인터페이스
    // 이 컨텍스트는 일반적인 애플리케이션 컨텍스트에 더해 웹 환경에 특화된 기능들을 포함합니다.
    // 이 컨텍스트를 사용해 MockMvc 객체를 설정하게 됩니다.


    private MockMvc mockMvc;
    // 제 서블릿 컨테이너를 구동하지 않고도 컨트롤러 테스트를 수행할 수 있게 해줍니다.

    @Test
    @BeforeEach
    // JUnit 5에서 각 테스트 메서드가 실행되기 전에 실행되는 메서드를 정의
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
    // MockMvc 객체를 초기화하는 데 사용되며, ctx는 WebApplicationContext를 의미합니다.
    // 이 코드를 통해 Spring의 웹 애플리케이션 컨텍스트를 기반으로 MockMvc를 설정합니다.

    // @BeforeEach 메서드에서 MockMvc를 초기화하여 테스트에서 사용할 준비를 합니다.



    // get list
    @Test
    public void list() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // ResultActions 리턴
                        .andReturn() // MvcResult 리턴
                        .getModelAndView() // ModelAndView 리턴
                        .getModelMap() // Model 리턴
        );
    }

    // create한 결과값을 log로
    @Test
    public void create() throws Exception {
        String resultPage = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/board/create")
                                .param("title", "테스트 새글 제목")
                                .param("content", "테스트 새글 내용")
                                .param("writer", "user1"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }


    // get 특정 no 조회
    @Test
    public void get() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("no", "1"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
        );
    }


    // update
    @Test
    public void update() throws Exception {
        String resultPage = mockMvc.perform(
                        MockMvcRequestBuilders.post("/board/update")
                                .param("no", "1")
                                .param("title", "수정된 테스트 새글 제목")
                                .param("content", "수정된 테스트 새글 내용")
                                .param("writer", "user00"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }


    // delete
    @Test
    public void delete() throws Exception {
// 삭제전 데이터베이스에 게시물 번호 확인할 것
        String resultPage = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/board/delete")
                                .param("no", "25") )
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }
}