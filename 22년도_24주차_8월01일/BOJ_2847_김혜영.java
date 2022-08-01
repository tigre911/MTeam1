import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2847_김혜영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//특정 레벨의 점수를 감소, 점수 오름차순으로
		//몇 번 감소시키면 되는지
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer=0;
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			
		}
	
		for(int i=N-1; i>0; i--) {
			if(arr[i-1]>=arr[i]) {
				answer += arr[i-1] - arr[i] + 1;
				arr[i-1] = arr[i] -1;
			}
		}
		
		System.out.println(answer);	
	}
}
