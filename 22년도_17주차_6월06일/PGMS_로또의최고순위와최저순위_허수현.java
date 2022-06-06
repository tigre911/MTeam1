package week19;

import java.util.Arrays;

public class PGMS_로또의최고순위와최저순위 {

	public static void main(String[] args) {
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		int[] answer = {0,0};
		int cnt = 0;
		
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				cnt++;
			}
		}
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				if(lottos[i] == win_nums[j]) {
					answer[0]++;
					answer[1]++;
				}
			}
		}
		answer[1] += cnt;
		System.out.println(cnt);
		System.out.println(answer[0]+", "+answer[1]);
		for (int i=0; i<2; i++) {
			if(answer[i] == 6) answer[i] = 1;
			else if(answer[i] == 5) answer[i] = 2;
			else if(answer[i] == 4) answer[i] = 3;
			else if(answer[i] == 3) answer[i] = 4;
			else if(answer[i] == 2) answer[i] = 5;
			else if(answer[i] == 1) answer[i] = 6;
			else answer[i] = 6;
		}
		System.out.println(answer[0]+", "+answer[1]);
	}

	class Solution {
		public int[] solution(int[] lottos, int[] win_nums) {
			int[] answer = {0,0};
			int cnt = 0;
			
			Arrays.sort(lottos);
			Arrays.sort(win_nums);
			for (int i = 0; i < 6; i++) {
				if (lottos[i] == 0) {
					cnt++;
				}
			}
			for (int i=0; i<6; i++) {
				for (int j=0; j<6; j++) {
					if(lottos[i] == win_nums[j]) {
						answer[0]++;
						answer[1]++;
					}
				}
			}
			answer[0] += cnt;
			
			for (int i=0; i<2; i++) {
				if(answer[i] == 6) answer[i] = 1;
				else if(answer[i] == 5) answer[i] = 2;
				else if(answer[i] == 4) answer[i] = 3;
				else if(answer[i] == 3) answer[i] = 4;
				else if(answer[i] == 2) answer[i] = 5;
				else if(answer[i] == 1) answer[i] = 6;
				else answer[i] = 6;
			}
			return answer;
		}
	}

}
