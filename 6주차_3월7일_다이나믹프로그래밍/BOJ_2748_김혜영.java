import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748_피보나치수2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n+1];
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2; i<n+1; i++) {
			arr[i] = arr[i-1]+arr[i-2]; //point
		}
		System.out.println(arr[n]);
	}
}
