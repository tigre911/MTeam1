import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_14495_백용민 {
     public static void main(String[] args) {
          ArrayList<Long> arr = new ArrayList<>();
          arr.add(1L);
          arr.add(1L);
          arr.add(1L);

          for (int i = 3; i < 116; i++) {
               long ans = arr.get(i - 1) + arr.get(i - 3);
               arr.add(ans);
          }
//          System.out.println(arr);
          Scanner sc = new Scanner(System.in);
          System.out.println(arr.get(sc.nextInt() - 1));
     }
}
