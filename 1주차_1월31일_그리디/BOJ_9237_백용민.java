package yes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_9237_백용민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Integer[] arr = new Integer[num];
		int[] day = new int[arr.length];
		int count = 2;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
//		Arrays.sort(arr, (i1, i2) -> i2 - i1);
		
//		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < arr.length; i++) {
			day[i] = arr[i] + count++;
		}
		
		//stream���� ��Ʈ������ ������ְ�, max(), getAsInt()�� int���� ��ȯ
		int max = Arrays.stream(day).max().getAsInt();
		
		System.out.println(max);
		
		
	}

}
