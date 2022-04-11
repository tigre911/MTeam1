import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//풀었는데 시간초과 떠서 다른 풀이 참고
public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());	//나무의 수
		int M = Integer.parseInt(st.nextToken());	//가져갈 나무의 길이
		
		int[] length = new int[N];	//나무의 길이
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			length[i]=Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(length);	//정렬
		
		// 이분 탐색 (upper bound)
		int min = length[0];
		int max = length[N-1];
			while(min < max) {
				int mid = (min + max) / 2;
				long sum = 0;
				for(int Height : length) {
					if(Height - mid > 0) { //자른 길이가 양수일 때만 더하기
						sum += (Height - mid);
					}
				}
				if(sum < M) { // 자르는 위치(높이)가 높다 > 자르는 높이를 낮춘다.
					max = mid;
				}
				else {	//자르는 위치(높이)가 낮다 > 자르는 높이를 높인다
					min = mid + 1;
				}
			}
			System.out.println(min - 1);	
			}
}
