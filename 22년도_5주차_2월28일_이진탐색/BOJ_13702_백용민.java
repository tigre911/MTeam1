import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13702_백용민 {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
          int num = Integer.parseInt(stt.nextToken());
          int pot = Integer.parseInt(stt.nextToken());
          int[] ml = new int[num];

          for (int i = 0; i < num; i++) {
               ml[i] = Integer.parseInt(br.readLine());
          }

          Arrays.sort(ml);

          long pl = 0;
          long pr = Integer.MAX_VALUE;
          long pc = 0;
          long ans = 0;

          while (pl <= pr) {
               pc = (pl + pr) / 2;
               int count = 0;

               for (int i : ml) {
                    count += i / pc;
               }


               if (pot <= count) {
                    ans = pc;
                    pl = pc + 1;
               } else {
                    pr = pc - 1;
               }

          }

          System.out.println(ans);
     }
}

