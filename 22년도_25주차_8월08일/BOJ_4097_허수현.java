package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4097_허수현 {

	public static void main(String[] args) throws IOException {
		// 수익
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
	    int[] revenue;
	    int[] dp;
		
		while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            revenue = new int[N];
            for (int i = 0; i < N; i++) {
                revenue[i] = Integer.parseInt(br.readLine());
            }

            // 2. dp
            dp = new int[N];
            for (int i = 0; i < N; i++) {
                dp[i] = revenue[i];
            }
            int answer = dp[0];

            for (int i = 1; i < N; i++) {
                if (revenue[i] + dp[i - 1] > dp[i]) {
                    dp[i] = revenue[i] + dp[i - 1];
                }
                answer = Math.max(dp[i], answer);
            }

            // 3. print
            System.out.println(answer);
        }

    }

}
