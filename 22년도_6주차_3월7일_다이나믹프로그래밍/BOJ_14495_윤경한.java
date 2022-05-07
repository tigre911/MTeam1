package baek.march_7_dynamic_programming;

import java.util.Scanner;

public class BOJ_14495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = 1;
        long b = 1;
        long c = 1;
        long answer = 0;
        if(n<=3){
            answer = 1;
        }else{
            long tmp = 0;
            while(n-->4){
                tmp = a+c;
                a = b;
                b = c;
                c = tmp;
            }
            answer = a+c;
        }
        System.out.println(answer);
    }   
}
