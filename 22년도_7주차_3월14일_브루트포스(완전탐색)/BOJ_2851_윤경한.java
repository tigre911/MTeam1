package baek.march_14_brute;

import java.util.Scanner;

public class BOJ_2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mushroom = new int[10];
        for(int i=0; i<10; i++){
            mushroom[i] = sc.nextInt();
        }
        int a = mushroom[0];
        int b = a;
        int cnt = 0;
        while(++cnt<10){
            b += mushroom[cnt];
            if(b>=100){
                break;
            }
            a = b;
        }
        int answer = 0;
        if(b<=100){
            answer = b;
        }else{
            answer = (b-100<=100-a) ? b : a;
        }
        System.out.println(answer);
    }
}
