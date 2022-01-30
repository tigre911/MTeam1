package yes;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14487_백용민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		System.out.println(sum - Arrays.stream(arr).max().getAsInt());
	}

}
