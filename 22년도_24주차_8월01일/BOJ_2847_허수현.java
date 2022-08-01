package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2847_허수현 {
	static int N = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		List<Integer> list = Arrays.asList(arr);
		Collections.reverse(list);
		Integer[] reverseArr = list.toArray(arr);
		System.out.println(Arrays.toString(reverseArr));
		
		int cnt = 0;
		for(int i=1; i<N; i++) {
			if(reverseArr[i] >= reverseArr[i-1]) {
				for(int j=0; reverseArr[i] >= reverseArr[i-1]; j++) {
					reverseArr[i]--;
					cnt++;
				}
				
			} else {
				continue;
			}
			
		}
		System.out.println(Arrays.toString(reverseArr));
		System.out.println(cnt);
	}

}
