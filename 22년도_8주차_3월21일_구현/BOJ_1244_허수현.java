package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int swCnt = Integer.parseInt(st.nextToken());
		int[] sw = new int[swCnt];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<swCnt; i++)
			sw[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int stu = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<stu; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			
			
			if(gender == 1) { // 남학생

				for(int j=num-1; j<swCnt; j+=num) {
					if (sw[j] == 1) sw[j] = 0;
					else sw[j] = 1;
				}
			}
			else { // 여학생
				int left = num-2;
				int right = num;
				
				while(true) {
					if(left<1 || right>swCnt) break;
					if(sw[left] != sw[right]) break;
					left--;
					right++;
				}
				
				for(int j=left; j<=right; j++) {
					if (sw[j] == 1) sw[j] = 0;
					else sw[j] = 1;
				}
			}
			
		}
		for (int i=0; i<swCnt; i++) {
			System.out.print(sw[i]+" ");
			if((i+1)%20 == 0) System.out.println();
		}
	}
}
