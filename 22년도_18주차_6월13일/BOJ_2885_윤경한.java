package baek.june_13;

import java.util.Scanner;

public class BOJ_2885 {
    public static void main(String[] args) throws Exception {  
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int cnt = 0;
        int c = 1;
        while(c<K){
            c *= 2;
        }
        String answer = ""+c;
        if(K!=c){
            while(K>0){
                c /= 2;
                cnt++;
                if(K>=c){
                    K -= c;
                }
            }
        }
        answer += " "+cnt;
        System.out.println(answer);
    }
}
