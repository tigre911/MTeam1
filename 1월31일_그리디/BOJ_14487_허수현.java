package week3;

import java.util.Scanner;

public class BOJ_14487 { // 욱제는 효도쟁이야!!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int[] arr = new int [a];
		
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int sum = 0;
		for (int i =0; i < a; i++) {
			sum += arr[i];
		}
		
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println(sum-max);
	}
}
