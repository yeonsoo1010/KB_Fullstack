package org.scoula.todo.context;

import org.scoula.todo.domain.UserVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Context {
    private UserVO user; // 로그인 사용자 정보, null이면 로그아웃 상태

    private Context() {
    }

    private static Context context = new Context();

    public static Context getContext() {
        return context;
    }
}