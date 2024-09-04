import java.sql.Connection;
import java.sql.DriverManager;

public class DB_test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/shop";
        String user = "root";
        String password = "0000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, user,password);
            System.out.println("Connected!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
