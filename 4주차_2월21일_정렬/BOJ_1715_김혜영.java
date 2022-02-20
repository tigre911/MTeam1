import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 1715번: 카드 정렬하기
public class BOJ_1715_김혜영 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		int num=0;
		Arrays.toString(arr);
		
		AA(N, num, arr);
	}
	
	static void AA(int N, int num, Integer[] arr) {
		//N이 짝수일 때
		if(N%2==0) {
			for(int i=0; i<N/2; i++) {
				arr[i] = arr[2*i]+arr[2*i+1];
				num += arr[i];
			}
			AA(N/2,num,arr); //재귀호출
		//N이 홀수일 때
		}else if(N%2==1){
			//N이 1일 때
			if(N==1) {
				System.out.println(num);
			//N이 1이 아닐 때
			}else {
				for(int i=0; i<(N-1)/2; i++) {
					arr[i]=arr[2*i]+arr[2*i+1];
					num += arr[i];
				}
				arr[(N-1)/2]=arr[N-1]; //마지막 원소 넣어주기
				AA((N+1)/2,num,arr); //재귀호출
			}
		}
	}
}
