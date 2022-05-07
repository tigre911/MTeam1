package week8;

import java.util.Scanner;

public class BOJ_2748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[91];
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<=n; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		System.out.println(arr[n]);
	}

}
