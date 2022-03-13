package study007;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13702_김다빈 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 막걸리 병수
		int k = Integer.parseInt(st.nextToken());	//	나눠줄 친구 수
		int ml[] = new int[n];						//	막걸리의 용량을 입력받아야 하므로!
		int sum=0;
		
		for(int i=0; i<n; i++) {
			ml[i] = Integer.parseInt(br.readLine());	//	막걸리 값 입력받아 저장하기		
			sum += ml[i];								//	막걸리 총량 구하기
		}	
		
		int s = sum/k;	//	s = 막걸리의 총량/친구 수 를 나눠 최대용량의 기준을 잡아준다. 
		int sumsum=0;	//	
		
		for(int i=0; i<1000; i++) {
			for(int j=0; j<n; j++) {
				sumsum += ml[j]/s;		//	각각의 막걸리병에서 / 용량을 나눠  값을 구해주고 나머지는 버리고 그 값들을 더해준다.
			}
				if (sumsum>=k) break;		//	만약 그 값들이 k(친구수)보다 크거나 같다면 종료한다.
			else{
				sumsum=0;		//	반복문 실행 전 sumsum의 값을 초기화
				s--;			//	s값을 내린다.
			}
		}	
		System.out.println(s);
	
	}

	
}
