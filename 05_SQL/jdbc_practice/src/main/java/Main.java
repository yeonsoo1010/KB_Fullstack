import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    // 회원가입 -- 입력값 scanner로 받아서 dao.insert(입력값들)
    public void join() {
        Scanner sc = new Scanner(System.in);

        System.out.println("id: ");
        String id = sc.nextLine();

        System.out.println("pw: ");
        String pw = sc.nextLine();

        System.out.println("name: ");
        String name = sc.nextLine();

        System.out.println("tel: ");
        String tel = sc.nextLine();

        MemberDao dao = new MemberDao();
        // dao.insert(id,pw, name, tel); //VO 어떻게 거치는지 확인 ..

        // VO만들어주기 !!!
        MemberVO member = new MemberVO(id, pw, name, tel);
        // 혹은
//        MemberVO member = new MemberVO();
//        member.setId(id);
//        member.setPw(pw);
//        member.setName(name);
//        member.setTel(tel);
        // VO로 dao.insert
        try {
            int result = dao.insert(member);
        } catch (Exception e){
            e.printStackTrace();
        }

        sc.close(); // scanner 해제
    }

    // 회원 탈퇴 - 입력값 받아서 dao.delete(id)
    public void delete() {
        Scanner sc = new Scanner(System.in);

        System.out.println("id:"); //id 받기
        String id = sc.nextLine();

        MemberDao dao = new MemberDao();
        try {
        dao.delete(id);
        } catch (Exception e){
            e.printStackTrace();
        }

        sc.close(); // scanner 해제
    }

    // 회원 정보 조회
    public void search() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("id: ");
        String id = sc.nextLine();

        MemberDao dao = new MemberDao();
        // MemberVO member = new MemberVO();
        try {
            MemberVO member = dao.one(id);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    // 로그인
    public void login() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("id: ");
        String id = sc.nextLine();
        System.out.println("pw: ");
        String pw = sc.nextLine();

        MemberDao dao = new MemberDao();
        MemberVO member = new MemberVO();

        member.setId(id);
        member.setPw(pw);

        try {
            int result = dao.login(member);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 메뉴 보이는 란 !!
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 회원 탈퇴");
            System.out.println("4. 회원 정보 조회");
            System.out.println("5. 종료");

            int choice = sc.nextInt();
            sc.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    main.login();
                    break;
                case 2:
                    main.join();
                    break;
                case 3:
                    main.delete();
                    break;
                case 4:
                    main.search();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

}
