package org.scoula.todo.context;
import lombok.Getter;
import lombok.Setter;
import org.scoula.todo.domain.UserVO;

import java.util.Map;

@Getter
@Setter
public class Context {
    private UserVO user = new UserVO("guest", "guest123", "방문자", "user");// 로그인 사용자 정보, null이면 로그아웃 상태
    private Map<Class, Object> map;
    private Context() {}
    private static Context context = new Context();
    public static Context getContext() {
        return context;
    }
}