import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25186 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//인원 = 옷 개수
		//이웃과 옷 겹치치 않아야
		//원형
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //옷 종류 N
		int[] arr = new int[N]; //종류별 옷 개수 배열 (N개)
		
		long sum=0;//합 long
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		
		
		Arrays.sort(arr);
		if(N==1 && arr[0]==1) {	//종류 1개, 사람 1명일 때 Happy
			System.out.println("Happy");
		}else if(N==1 && arr[0]!=1){	//종류 1개, 사람 여러명일 때 Unhappy
			System.out.println("Unhappy");
		}else {	
			if(arr[N-1]>sum-arr[N-1]) { // 제일 큰 수가 다른 수 합한것보다 크면 unhappy
				System.out.println("Unhappy");
			}else {
				System.out.println("Happy");
			}
		}
	}
}
