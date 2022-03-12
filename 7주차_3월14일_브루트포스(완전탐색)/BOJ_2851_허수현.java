package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] M = new int[10];
		int score = 0;

		for (int i = 0; i < 10; i++) {
			M[i] = Integer.parseInt(br.readLine());
		}
		outerLoop:
		for (int i = 0; i < 10; i++) {
			score += M[i];

			if (score == 100) {
				break;
			}
			if (score > 100) {
				if (/* 100 - score - M[i] == score - 100 */Math.abs((score - M[i]) - 100) == score - 100) {
					break outerLoop;
				} else {
					score -= M[i];
				}
			}
		}
		System.out.println(score);
	}
}
