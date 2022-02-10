package baek;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int five=N/5; five>=0; five--){
            if((N-five*5)%3==0){
                System.out.println(five+(N-five*5)/3);
                break;
            }else if(five<=0){
                System.out.println(-1);
            }
        }
    }
}
