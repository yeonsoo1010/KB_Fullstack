import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class MemberDao {
    // 등록 insert
    //public int insert(String id, String pw, String name, String tel) throws SQLException, ClassNotFoundException {
    public int insert(MemberVO member) throws SQLException, ClassNotFoundException {
        // VO 거쳐야 할 듯 !!!!!!!!!!
        try {
            // 1 드라이버(커넥터) 설정
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("1 드라이버 설정");

            // 2. db 연결
            String url = "jdbc:mysql://127.0.0.1:3306/shop";
            String user = "root";
            String password = "0000";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("2. DB 연결 완료");

            // 3. sql 문 생성
            try {
                String sql = "insert into member values(?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);

//            ps.setString(1, id);
//            ps.setString(2, pw);
//            ps.setString(3, name);
//            ps.setString(4, tel);
                ps.setString(1, member.getId());
                ps.setString(2, member.getPw());
                ps.setString(3, member.getName());
                ps.setString(4, member.getTel());
                System.out.println("3 sql 생성");

                // 4 sql문 전송
                int result = ps.executeUpdate();
                System.out.println("4 sql문 전송, 인서트 행 개수: " + result);

                ps.close();

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return 0; // 예외가 발생한 경우 0을 반환
            } finally {
                // 닫기
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 삭제 delete
    public int delete(String id) throws SQLException, ClassNotFoundException {
        // 1 드라이버(커넥터) 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1 드라이버 설정");

        // 2. db 연결
        String url = "jdbc:mysql://127.0.0.1:3306/shop";
        String user = "root";
        String password = "0000";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결 완료");

        // 3. sql 문 생성
        try {
            String sql = "delete from member where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            System.out.println("3. sql문 생성");

            // 4. sql문 실행
            int result = ps.executeUpdate();
            System.out.println("4. sql문 실행, delete행 개수: " + result);

            //5. 닫기
            ps.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 닫기
            conn.close();
            return 0; // 예외가 발생한 경우 0을 반환
        }
    }

    // 조회 one
    public MemberVO one(String id) throws SQLException, ClassNotFoundException {
        // 1 드라이버(커넥터) 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1 드라이버 설정");

        // 2. db 연결
        String url = "jdbc:mysql://127.0.0.1:3306/shop";
        String user = "root";
        String password = "0000";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결 완료");


        try {
            // 3. sql문 생성
            String sql = "select * from member where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            // 4. sql문 실행
            ResultSet rs = ps.executeQuery();
            MemberVO member = map(rs);

            //5. 닫기
            rs.close();
            ps.close();
            return member;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conn.close();
        }
    }

    // 로그인 login
    public int login(MemberVO member) throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            // 1 드라이버(커넥터) 설정
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1 드라이버 설정");

            // 2. db 연결
            String url = "jdbc:mysql://127.0.0.1:3306/shop";
            String user = "root";
            String password = "0000";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("2. DB 연결 완료");

            try {
                String sql = "select * from member where id=? and pw = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, member.getId());
                ps.setString(2, member.getPw());

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("로그인 성공");
                    result = 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private MemberVO map(ResultSet rs)  throws SQLException {

        MemberVO member = new MemberVO();
        while(rs.next()){
            member.setId(rs.getString("id"));
            member.setPw(rs.getString("pw"));
            member.setName(rs.getString("name"));
            member.setTel(rs.getString("tel"));
        }

        return member;
    }
}
