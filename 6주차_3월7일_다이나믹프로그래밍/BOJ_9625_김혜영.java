import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9625_BABBA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		//B기준으로 arr = 0,1,1,2,3,5,8,13...
		//			K =   1,2,3,4,5,6,7...이므로 K와 arr의 인덱스가 동일
		
		int[] arr = new int[K+1];
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2; i<K+1; i++) {
			arr[i] = arr[i-1]+arr[i-2]; //point
		}
		
		System.out.println(arr[K-1]+ " "+arr[K]); //A B
	}
}
