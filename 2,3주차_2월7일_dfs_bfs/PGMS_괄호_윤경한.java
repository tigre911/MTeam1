package baek.feb_14_extra;

import java.util.Scanner;

public class PGMS_gwalho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = solution(sc.nextLine());
        System.out.println(result);
    }
    public static String solution(String p) {
        String answer = "";
        
        if(p.length()<=0){
            return answer;
        }

        int left = 0;
        int right = 0;
        char start = p.charAt(0);

        if(start=='('){
            for(int i=0; i<p.length(); i++){
                if(p.charAt(i)=='('){
                    left++;
                }else{
                    right++;
                }
                if(left==right){
                    return p.substring(0,i+1)+solution(p.substring(i+1));
                }
            }
            answer = p;
        }else{
            String u = "";
            String v = "";
            for(int i=0; i<p.length(); i++){
                if(p.charAt(i)==')'){
                    right++;
                }else{
                    left++;
                }
                if(left==right){
                    u = p.substring(0,i+1);
                    v = p.substring(i+1);
                    break;
                }
            }
            StringBuilder sb = new StringBuilder("(");
            sb.append(solution(v));
            sb.append(")");
            char[] uArr = u.toCharArray();
            for(int i=1; i<uArr.length-1; i++){
                char tmp = uArr[i]=='(' ? ')' : '(';
                sb.append(tmp);
            }
            answer = sb.toString();
        }

        return answer;
    }
}
