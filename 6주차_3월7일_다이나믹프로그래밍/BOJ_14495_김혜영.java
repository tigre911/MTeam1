import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14495_피보나치_비스무리한_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n==1||n==2||n==3) {
			System.out.println(1);
		} else {
		long [] arr = new long[n+1];
		arr[1]=arr[2]=arr[3]=1;
		
		for(int i=4; i<=n; i++) {
			arr[i]=arr[i-1]+arr[i-3];
		}
		System.out.println(arr[n]);
		}
	}
}
