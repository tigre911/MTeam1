package baek.march_21_impl;

public class PGMS_gwalho {
    public static void main(String[] args) {
        System.out.println(solution("((((()()))))"));
    }
    static boolean solution(String s){
        if(s.charAt(0)==')' || s.length()%2!=0){
            return false;
        }

        int open = 0;
        int close = 0;
        boolean answer = true;

        for(char sChar:s.toCharArray()){
            if(sChar=='('){
                open++;
            }else{
                close++;
            }
            if(open<close){
                break;
            }
        }
        if(open!=close || s.charAt(s.length()-1)!=')'){
            answer = false;
        }

        return answer;
    }
}
