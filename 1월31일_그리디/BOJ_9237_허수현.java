package week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_9237 { // 이장님 초대 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] tree = new Integer[N];
		int sum = 1;
		
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(tree,Collections.reverseOrder()); // Collections.reverseOrder() sort내림차순
		// int는 primitive type이어서 객체가 아니기 때문에 Integer로 사용한다.
		
		for (int i = 0; i < N; i++) {
			if (sum < i + tree[i]) {
				sum += (i+tree[i])-sum;
			}
		}
		System.out.println(sum+2);
	}
}
