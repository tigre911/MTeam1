package study023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17212 {
	
	private static final int[] coin = { 1, 2, 5, 7 };

	private void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 토끼가 지불해야하는 금액
		int n = Integer.parseInt(br.readLine());
		
		// 토끼가 합법적으로 낼 수 있는 동전 개수 배열
		int[] dp = new int[n + 1];
		
		// 지불 최대 금액, 100000
		Arrays.fill(dp, 100001);
		
		dp[0] = 0;
		
		// 지불금액만큼 반복
		for (int i = 1; i <= n; i++) {
			// 동전의 종류 4개
			for (int j = 0; j < 4; j++) {
				// 만약, 지불금액 - coin[j] 0보다 작으면 끝내버리기
				if (i - coin[j] < 0)
					continue;
				
				// dp[i], dp[i-코인종류]+1 중 비교하여 더 작은 값을 [i]에 저장
				dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
			}
		}
		System.out.print(dp[n]);
	}

	public static void main(String[] args) throws Exception {
		new BOJ_17212().solution();
	}
	
}
