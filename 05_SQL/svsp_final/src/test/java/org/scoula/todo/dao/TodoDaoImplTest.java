package org.scoula.todo.dao;


import org.junit.jupiter.api.*;
import org.scoula.todo.common.JDBCUtil;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoDaoImpl;
import org.scoula.todo.domain.TodoVO;
import org.scoula.todo.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoDaoTest {
    TodoDao dao = new TodoDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("테스트 데이터를 생성한다.")
    @Disabled
    public void testData() throws SQLException
    {
        for(int
            i = 0;
            i <= 163;
            i++) {
            TodoVO todo = TodoVO.builder()
                    .title("테스트 Todo " +
                            i
                    )
                    .description("테스트 Todo 설명" +
                            i
                    )
                    .userId("guest")
                    .done(false)
                    .build();
            dao.create
                    (todo);
        };
    }

    @Test
    @DisplayName("todo를 등록합니다.")
    @Order(1)
    void create() throws SQLException {
        // when
        TodoVO todo = new TodoVO("title", "desc123", false, "ADMIN");
        // given
        int test = dao.create(todo);
        // then
        Assertions.assertEquals(1, test);
    }

    @Test
    @DisplayName("특정 유저의 Todo 목록을 추출합니다.")
    @Order(2)
    void getList() throws SQLException {
        // when
        String userId = "ADMIN";
        // given
        List<TodoVO> list = dao.getList(userId);
//        for (TodoVO vo : list) {
//            System.out.println(vo);
//        }
        // then
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("특정 todo 1건을 추출합니다.")
    @Order(3)
    void get() throws SQLException {
        TodoVO todo = dao.get("ADMIN", 5L).orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(todo);
    }
//
//    @Test
//    @DisplayName("user 의 정보를 수정합니다.")
//    @Order(4)
//    void update() throws SQLException {
//        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
//        user.setName("쌤즈3");
//        int count = dao.update(user);
//        Assertions.assertEquals(1, count);
//    }
//
//    @Test
//    @DisplayName("user 를 삭제합니다.")
//    @Order(5)
//    void delete() throws SQLException {
//        int count = dao.delete("ssamz3");
//        Assertions.assertEquals(1, count);
//    }
}
