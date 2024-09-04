import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DB_test2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 1. 드라이버(커넥터) 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database...");

        // 2. db 연결
        String url = "jdbc:mysql://127.0.0.1:3306/shop";
        String user = "root";
        String password = "0000";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to database...");

        // dao로 delete
        System.out.println("id:"); //id 받기
        String id = sc.nextLine();

        MemberDao dao = new MemberDao();
        dao.delete(id);

        sc.close();
    }
}
