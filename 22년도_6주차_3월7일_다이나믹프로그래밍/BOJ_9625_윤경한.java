package baek.march_7_dynamic_programming;

import java.util.Scanner;

public class BOJ_9625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = 1;
        int B = 0;
        int tmp = 0;

        while(K-->0){
            tmp = A;
            A = B;
            B += tmp;
        }
        System.out.println(A+" "+B);
    }
}
