import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_백용민 {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int MyNum = Integer.parseInt(br.readLine());
          StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
          int[] MyNumCard = new int[MyNum];

          int k = 0;
          while (stt.hasMoreTokens()) {
               MyNumCard[k++] = Integer.parseInt(stt.nextToken());
          }

          int CardNum = Integer.parseInt(br.readLine());
          int[] CardNumCard = new int[CardNum];
          stt = new StringTokenizer(br.readLine(), " ");

          k = 0;
          while (stt.hasMoreTokens()) {
               CardNumCard[k++] = Integer.parseInt(stt.nextToken());
          }

          Arrays.sort(MyNumCard);
          int j = 0;
          for (int i : CardNumCard) {
               int what = binarySearch(MyNumCard, i);
               if (what != -1) {
                    System.out.print(1 + " ");
               } else {
                    System.out.print(0 + " ");
               }
          }
     }

     static int binarySearch(int[] arr, int num) {
          int pl = 0;
          int pr = arr.length - 1;


          do {
              int pc = (pl + pr) / 2;
               if (arr[pc] < num) {
                    pl = pc + 1;
               } else if (arr[pc] > num) {
                    pr = pc - 1;
               } else {
                    return pc;
               }
          } while (pl <= pr);

          return -1;
     }
}
