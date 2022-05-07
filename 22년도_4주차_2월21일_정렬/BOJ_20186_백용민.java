import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_20186_백용민 {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
          int[] arr = new int[2];
          for (int i = 0; i < 2; i++) {
               arr[i] = Integer.parseInt(stt.nextToken());
          }

          stt = new StringTokenizer(br.readLine(), " ");
          Integer[] arr2 = new Integer[arr[0]];
          int i = 0;
          while (stt.hasMoreTokens()) {
               arr2[i++] = Integer.parseInt(stt.nextToken());
          }

          Arrays.sort(arr2, Collections.reverseOrder());
          int sum = 0;
          for (int j = 0; j < arr[1]; j++) {
               sum += arr2[j];
          }

          System.out.println(sum - arr[1] * (arr[1] - 1) / 2);
     }
}
