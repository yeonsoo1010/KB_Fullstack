package com.multi;

import java.util.List;
import java.util.Scanner;

public class CityUI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("선택 1) 데이터 삽입, 2) 데이터 검색>> ");
        int choice = sc.nextInt();
        sc.close();

        if (choice == 1) {

            //insert 기능
            CityDAO cityDAO = new CityDAO();
            cityDAO.insert();
            System.out.println("삽입처리 호출 완료됨.");
        } else if (choice == 2) {

            //select 기능
            CityDAO cityDAO2 = new CityDAO();
            int ID = 4088;

            //5-2.  ID가 4088이상인 도시들의 행이 검색되도록 select메서드를 호출하여
            //      검색 결과를 출력하는 처리를 완성하시오.
            //      조건 1) 출력시 지역명은 앞에서부터 4글자만 추출하여 출력
            //      조건 2) 반복문으로 출력시, for문, fot-each문 중 하나를 선택하여 사용 가능

            /***********************************************
             * 구현 코드
             */
            List<CityVO> result = cityDAO2.select(ID);
            // System.out.println("result: " + result);
            int totalNum = result.size();
            System.out.println("전체 도시수: " + totalNum);

            System.out.println("----------- 도시 목록 -----------");
//            for (int i=0; i<result.size(); i++) {
//                int id = result[i].getInt(0);
//            }
            for (CityVO tmp : result) {
                int id = tmp.getID();
                String countryCode = tmp.getCountryCode();
                String district = tmp.getDistrict();
                int population = tmp.getPopulation();

                System.out.println("아이디>> " + id + ", 국가코드>> " + countryCode + ", 지역명>> " + district + ", 인구수>> " + population);
            }
            System.out.println("----------- 도시 목록 -----------");
        } else {
            System.out.println("선택이 올바르지 않음.");
        }
    }
}
