package study025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4097_김다빈 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				break;
			}
			
			int arr[] = new int[n];
			int max = Integer.MIN_VALUE;

			for(int i=0; i<n; i++) {
				int m = Integer.parseInt(br.readLine());
				arr[i] = m;
				
				if(i > 0) {
					int k = arr[i-1];
					
					if(m+k > m) {
						arr[i] = m+k; 
					}
				}
				
				max = Math.max(max, arr[i]);
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
	}
}
