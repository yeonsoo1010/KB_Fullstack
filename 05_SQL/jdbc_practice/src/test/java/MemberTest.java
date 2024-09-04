import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MemberTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 1. 드라이버(커넥터) 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 완료");

        // 2. db 연결
        String url = "jdbc:mysql://127.0.0.1:3306/shop";
        String user = "root";
        String password = "0000";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결 완료");

        // 3. SQL문 생성
        System.out.println("id:"); //id 받기
        String id = sc.nextLine();

        System.out.println("password:"); //password 받기 = 변수이름 pw
        String pw = sc.nextLine();

        System.out.println("name:"); //name 받기
        String name = sc.nextLine();

        System.out.println("tel:"); //tel 받기
        String tel = sc.nextLine();

        String sql = "insert into member values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, pw);
        ps.setString(3, name);
        ps.setString(4, tel);
        System.out.println("3. SQL문 생성 완료");

        // 4. SQL문 전송
        int updatedRows = ps.executeUpdate();
        System.out.println("4. SQL문 전송 완료, 업데이트된 행 개수: " + updatedRows);


        // 5. 자원 해제
        ps.close(); // prepareStatement
        conn.close(); // connection
        sc.close(); // scanner
        // resultset
    }
}
