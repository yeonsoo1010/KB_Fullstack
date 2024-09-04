package com.multi;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//mySQLDB연결 처리 담당 클래스
public class CityDAO {
    private Connection conn;
    private String url = "jdbc:mysql://localhost:3306/world2";
    private String user = "root";
    private String password = "0000";

    //객체생성시 클래스로딩과 DB연결
    public CityDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("발생한 에러 정보>> " + e.getMessage());
        }
    }

    //city테이블에 데이터를 삽입 처리 기능 구현
    //문제 4-2. insert()메서드를 완성하여 데이터 삽입 처리를 구현하시오.
    //     조건1) try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //     조건2) db처리와 관련된 모든 객체에 대해 "자원해제 처리"를 하시오.
    //     조건3) city테이블에 넣을 데이터는 "sql문에 직접 필드 타입에 맞게 넣어" SQL문을 완성하시오.
    //     조건4) 해당 메서드에서 데이터 삽입 처리후 결과는 반환하지 않는다.

    public void insert() {
        // 1 driver 만들기, 2 conncection 연결하기까지 완료
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (Exception e) {
//            System.out.println("발생한 에러 정보>> " + e.getMessage());
//        }
        //3 SQL문 완성
        /***********************************************
         * 구현 코드
         */
        try {
            // 3 SQL문 작성
            String sql = "insert into city(name, countrycode, district, population) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Win");
            ps.setString(2, "OMN");
            ps.setString(3, "Center");
            ps.setInt(4, 1000);

            // 4 SQL문 실행 - return은 없음
            ps.executeUpdate();

            // 5 다 닫기
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    } //insert기능 구현

    //city테이블에서 검색하여 UI에 반환 처리 기능 구현
    //문제 5-1. select()메서드를 완성하여 데이터 검색 처리를 구현하시오.
    //   조건1)  try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //   조건2)  db처리와 관련된 모든 객체에 대해 "자원해제 처리"를 하시오.
    //   조건3)  city테이블에서 검색에 사용할 SQL문은
    //          CityUI.java에서 전달된 데이터를 이용하여 완성한다.
    //   조건4)  해당 메서드에서 데이터 검색 처리후 결과 목록은 List<CityVO>타입으로 반환한다.

//    public List<CityVO> select(int ID) {
//// 1 driver 만들기, 2 conncection 연결하기까지 완료
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
////            System.out.println("Connecting to database...");
////            conn = DriverManager.getConnection(url, user, password);
////        } catch (Exception e) {
////            System.out.println("발생한 에러 정보>> " + e.getMessage());
////        }
//        //3 SQL문 완성
//        /***********************************************
//         * 구현 코드
//         */
//        try {
//            // 3 SQL문 작성
//            String sql = "select * from city where id >= ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, ID);
//            // 확인 - ok
//            System.out.println("3 SQL문 작성 완료");
//
//            // 4 SQL문 실행
//            ResultSet rs = ps.executeQuery();
//            List<CityVO> cityList = mapList(rs);
//            System.out.println("4 SQL문 실행 완료, cityList값: " + cityList);
//
//            // 5 다 닫고 반환하기
//            ps.close();
//
//            return cityList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }//select기능 구현

    // ResultSet을 CityVO로 만들어주는 함수 따로 생성하기 (ResultSet -> CityVO)
    private CityVO map(ResultSet rs) throws SQLException {
        CityVO city = new CityVO();
        while(rs.next()) {
            city.setID(rs.getInt(1));
            city.setName(rs.getString(2));
            city.setCountryCode(rs.getString(3));
            city.setDistrict(rs.getString(4));
            city.setPopulation(rs.getInt(5));
        }
        return city;
    }

    // ResultSet을 CityVO로 바꿨다가, CityVO를 list로 변환하는 함수 따로 생성하기 (ResultSet -> list)
    private List<CityVO> mapList(ResultSet rs) throws SQLException {
        CityVO city = map(rs);
        List<CityVO> cityList = new ArrayList<CityVO>();
        cityList.add(city);
        return cityList;
    }

    public List<CityVO> select(int ID) {
// 1 driver 만들기, 2 conncection 연결하기까지 완료
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (Exception e) {
//            System.out.println("발생한 에러 정보>> " + e.getMessage());
//        }
        //3 SQL문 완성
        /***********************************************
         * 구현 코드
         */
        try {
            // 3 SQL문 작성
            String sql = "select * from city where id >= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            // 확인 - ok
            // System.out.println("3 SQL문 작성 완료");

            // 4 SQL문 실행
            ResultSet rs = ps.executeQuery();
            // 확인 - ok
            // System.out.println("4-1 ResultSet 생성" + rs.toString());

            CityVO city = new CityVO();
            List<CityVO> cityList = new ArrayList<CityVO>();

//            for (CityVO tmp : cityList) {
//                while (rs.next()) {
//                    tmp.setID(rs.getInt(1));
//                    tmp.setName(rs.getString(2));
//                    tmp.setCountryCode(rs.getString(3));
//                    tmp.setDistrict(rs.getString(4));
//                    tmp.setPopulation(rs.getInt(5));
//
//                    cityList.add(tmp);
//                }
//            }
            while (rs.next()) {
                city.setID(rs.getInt(1));
                city.setName(rs.getString(2));
                city.setCountryCode(rs.getString(3));
                city.setDistrict(rs.getString(4));
                city.setPopulation(rs.getInt(5));
                // System.out.println(city); // city에 문제 없음. list에 하나씩 저장하는 것에서 문제가 있음

                cityList.add(city);
                // System.out.println(cityList); // ㅁㅊ 문제 없는 거 맞음 .... ;;; 아 전 값들이 다 대체됨 ... ;
            }
            // 확인
            // System.out.println("4-2 CityVO city 생성, city: " + city);
            // System.out.println("4 SQL문 실행 완료, cityList값: " + cityList); // 여기서 문제

            // 5 다 닫고 반환하기
            ps.close();
            rs.close();

            return cityList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }//select기능 구현
}


