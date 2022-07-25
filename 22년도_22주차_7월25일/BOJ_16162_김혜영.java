import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가희와 3단 고음
//이어지는 수열 개수 구하기	
public class BOJ_16162_김혜영 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken()); //첫항
		int D = Integer.parseInt(st.nextToken()); //공차
		int answer=0;	
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int num=A;
		for(int i=0; i<N; i++) {
			if(arr[i]==num) {
				answer++;
				num += D; //다음 항
			}
		}
		System.out.println(answer);
	}
}
