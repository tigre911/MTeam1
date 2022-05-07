import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18353_백용민 {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
          int[] arr = new int[n];
          int[] dp = new int[n];
          Arrays.fill(dp, 1);
//          1 1 2 3 3 4 5 5

          int l = 0;
          while (stt.hasMoreTokens()) {
               arr[l++] = Integer.parseInt(stt.nextToken());
          }

          for(int i=1;i<n;i++){
               for(int j=0;j<=i;j++){
                    if(arr[i]<arr[j]){
                         dp[i]=Math.max(dp[i],dp[j]+1);
                    }
               }
          }
          Arrays.sort(dp);

//          System.out.println(Arrays.toString(dp));
          System.out.println(n-dp[n - 1]);
     }
}
