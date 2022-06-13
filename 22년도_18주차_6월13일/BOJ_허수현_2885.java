package week19;

import java.util.Scanner;

public class BOJ_2885 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int size = 1;
		int cnt = 0;
		int minsize = 0;
		
		while(size < K) {
			size *= 2;
			minsize = size;
		}
		while(K > 0) {
			if(K >= size) {
				K -= size;
			} else {
				size /= 2;
				cnt++;
			}
		}
		sc.close();
		System.out.println(minsize + " " + cnt);
	}
}
