package baek.march_7_dynamic_programming;

import java.util.Scanner;

public class BOJ_2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x1 = 0;
        long x2 = 1;
        long tmp = 0;
        
        if(n<2){
            System.out.println(n);
        }else{
            while(n-->=2){
                tmp = x1+x2;
                x1 = x2;
                x2 = tmp;
            }
            System.out.println(x2);
        }
    }
    
}
