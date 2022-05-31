package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25186 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		long max = 0; // 가장 많은 옷의 개수
		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			max = (arr[i] > max) ? arr[i] : max;
			sum += arr[i];
			
			if(sum<0) {
				System.out.println("Happy");
			}
		}
		if(n==1) {
			System.out.println("Happy");
		}
		else if(sum/2 >= max) {
			System.out.println("Happy");
		}else {
			System.out.println("Unhappy");
		}
			
	}

}
