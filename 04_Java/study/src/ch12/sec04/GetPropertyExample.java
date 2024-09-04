package ch12.sec04;

import java.util.Properties; // 리플렉션 기능
import java.util.Set;

public class GetPropertyExample {
    public static void main(String[] args) {
        // 운영체제 명 출력
        String osName = System.getProperty("os.name");

        // 로그인 사용자 명 & 홈 디렉토리
        String userName = System.getProperty("user.name");
        String HomeDir = System.getProperty("user.home");

        System.out.println(osName);
        System.out.println(userName);
        System.out.println(HomeDir);
    }
}
