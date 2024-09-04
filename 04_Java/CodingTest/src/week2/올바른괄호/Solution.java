package week2.올바른괄호;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // for 반복문을 돌려서 문자 하나하나에 접근한다
        // 열린 괄호면
            // stack에 넣어준다
        // 닫힌 괄호면
            // stack pop()

        // s.isEmpty -> stack이 비어있으면 true, 비어있지 않으면 false


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "(())()";
        boolean result = s.solution(s1);
        System.out.println(result);
    }
}
