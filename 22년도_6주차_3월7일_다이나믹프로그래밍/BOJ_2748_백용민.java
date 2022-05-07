import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2748_백용민 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();

          BigInteger a = BigInteger.ZERO;
          BigInteger b = BigInteger.ONE;
          BigInteger tmp;

          for (int i = 0; i < n; i++) {
               tmp = a;
               a = b;
               b = tmp.add(b);
               if (i == n - 1) {
                    System.out.println(a);
               }
          }
     }
}
