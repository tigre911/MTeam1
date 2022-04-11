package study012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1431_김다빈 {
	public static int add(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sum += s.charAt(i) - '0';
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}

		// Arrays.sort 오름차순 정렬
		// 배열, 첫번째 조건, 두번째 조건
		Arrays.sort(arr, (first, second) -> {
			if (first.length() < second.length()) {
				return -1;
			} else if (first.length() == second.length()) {
				if (add(first) == add(second)) {
					return first.compareTo(second);
				} else {
					return Integer.compare(add(first), add(second));
				}
			} else {
				return 1;
			}
		});
		for (String i : arr) {
			System.out.println(i);
		}
		br.close();

	}
}
