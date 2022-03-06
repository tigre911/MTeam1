package week8;

import java.util.Scanner;

public class BOJ_14495 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[117];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for(int i=4; i<=n; i++) {
			arr[i] = arr[i-3] + arr[i-1];
		}
		System.out.println(arr[n]);
	}

}
