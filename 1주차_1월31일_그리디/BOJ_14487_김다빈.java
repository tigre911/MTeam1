package study003;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14487_김다빈 {

	public static void main(String[] args) {
		
		/*
		 문제접근
		 
		 1)	마을 수 (배열의 길이 입력받기)
		 2)	마을 경비를 각 배열에 입력받기			/ (for, scanner 사용)
		 3) 배열 오름 차순 구하기					/ (Arrays.sort 사용해서 받기)
		 4) 배열-1 까지 합을 더하기				/ (length-1 까지 sum으로 더해서 받기)
		 */
		
		Scanner sc32 = new Scanner(System.in);
		
		//	1-----------------------
		int n = sc32.nextInt();
		
		int[] ar32 = new int[n];
		
		//	2-----------------------
		for(int i=0; i<ar32.length; i++) {
			ar32[i] = sc32.nextInt();
		}
		
		//	3------------------------
		//	Arrays.sort 사용하기
		Arrays.sort(ar32);
	
		//	4------------------------
		int sum=0;
		for(int i=0; i<ar32.length-1; i++) {
			sum += ar32[i];
		}	
		System.out.print(sum);
		
		
	}
}
