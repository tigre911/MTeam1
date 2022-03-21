package Algorithm.PGMS.올바른괄호;

import java.util.Stack;

public class PGMS_올바른괄호_정구현 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("()()"));
        System.out.println(s.solution("(())()"));
        System.out.println(s.solution(")()("));
        System.out.println(s.solution("(()("));
    }


}

class Solution{
    public boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);


            if(temp == ')' && stack.size() == 0) { //첫번째 괄호가 ')'일경우 false 리턴
                return false;
            } else if(temp == ')' && stack.size() > 0) { //열린 괄호쌍 하나 제거
                stack.pop();
            } else if(temp == '(') {//열린 괄호 하나 추가
                stack.push(temp);
            }
        }

        //열린괄호가 하나 이상 남아있을경우 fasle 리턴
        if(stack.size() > 0) answer = false;

        return answer;

    }
}