package week6;

import java.io.*;
import java.util.*;

public class BOJ_20186 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sum = 0;
		Integer arr[] = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}sc.close();
		
		Arrays.sort(arr,Collections.reverseOrder());
		
		for(int i = 0; i < K; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum - (K*(K-1))/2 );
	}
	

}
