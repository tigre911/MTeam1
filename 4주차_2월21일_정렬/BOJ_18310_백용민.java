import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18310_백용민 {
     public static void main(String[] args) throws IOException {

          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          int homeNum = Integer.parseInt(br.readLine());
          StringTokenizer stt = new StringTokenizer(br.readLine());

          int []distance = new int[homeNum];
          int []homes = new int[homeNum];

          int i=0;
          while (stt.hasMoreTokens()){
               homes[i++]=Integer.parseInt(stt.nextToken());
          }

          Arrays.sort(homes);

          bw.write(Integer.toString(homes[(homeNum-1)/2]));
          bw.flush();
          bw.close();
     }
}
