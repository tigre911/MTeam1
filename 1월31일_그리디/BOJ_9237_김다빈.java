package study003;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.sound.sampled.ReverbType;

public class BOJ_9237_김다빈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		
		풀이) 
		1.	배열에 수를 입력받는다. 								/	(배열에 스캐너사용)
		2.	입력받은 배열을 내림차순으로 정렬							/	(Arrays.sort 사용하기)
		3.	각 배열에 첫번째 배열에 +1, 두번째 배열 +2... n번째 배열에 +n 	/	(for 사용)
		4.	배열에서 가장큰 값을 구하여 +1 해주면 이장님을 초대하는 날짜
		
		 */
		
		
		//	1---------------------------------
		Scanner s31 = new Scanner(System.in);
		int n = s31.nextInt();
		int tmp;
		//	int형이아닌 integer사용 하는이유는 Collections.reverseOder()사용하려면 integer형이여야한다.
		//	int형은 객체가 아닌데 sort는 객체형잉기 때문에 오류가 남
		Integer[] ar31 = new Integer[n];
		
		for(int i=0; i<n; i++) {
			ar31[i] = s31.nextInt();
		}
				
		//	2---------------------------------
		//	arrays. sort 사용
		//	사용 방법 
		//	Arrays.sort(배열이름, Collections.reverseOrder())
		Arrays.sort(ar31, Collections.reverseOrder());

		//	3---------------------------------
		//	배열에 순서대로 +1,+2,+3...해주기
		
		for(int i=0; i<ar31.length; i++) {
			ar31[i] = ar31[i]+i;
		}
		
		//	4---------------------------------
		//	배열중 가장 큰 값을 구해주기
		int max = ar31[0];
		for(int i=0; i<ar31.length; i++) {
			if(max < ar31[i]) {
				max = ar31[i];
			}
		}
		//	가장 큰 값에 심는날 +1 과 이장님에게 그다음날 소개하므로 +1, 총 +2해주기
		System.out.print(max+2);
	}

}
