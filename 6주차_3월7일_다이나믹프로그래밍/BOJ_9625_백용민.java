import java.util.Scanner;

public class BOJ_9625_백용민 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();

          int ansA = (int)(((Math.pow((1 + Math.sqrt(5)), n - 1)) - (Math.pow((1 - Math.sqrt(5)), n - 1))) / (Math.pow(2, n - 1) * Math.sqrt(5)));

          int ansB = (int)(((Math.pow((1 + Math.sqrt(5)), n)) - (Math.pow((1 - Math.sqrt(5)), n))) / (Math.pow(2, n) * Math.sqrt(5)));

          System.out.println(ansA + " " + ansB);
     }
}
