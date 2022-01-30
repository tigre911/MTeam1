package yes;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_13164_백용민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		int sum = 0;

		int[] arr = new int[num];
		Integer[] diff = new Integer[num-1];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

//		System.out.println("arr = " + Arrays.toString(arr));

		for(int i = 0; i < arr.length-1; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		
//		System.out.println("diff = "  + Arrays.toString(diff));
		
		Arrays.sort(diff);
		
//		System.out.println("diff = "  + Arrays.toString(diff));
		for(int i = 0; i < num - num2; i++) {
			sum += diff[i];
		}

		System.out.println(sum);
	}
}
