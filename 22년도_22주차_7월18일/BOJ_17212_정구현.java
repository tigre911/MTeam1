package Algorithm.BaekjoonOnlineJudge.BOJ_17212;

import java.io.*;
import java.util.Arrays;

public class BOJ_17212_Á¤±¸Çö {

    public static void main(String[] args) throws IOException {
        int[] coin = {1,2,5,7};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                if (i-coin[j]<0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin[j]]+1);
            }
        }
        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
