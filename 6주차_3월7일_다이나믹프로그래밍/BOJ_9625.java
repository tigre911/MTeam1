package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9625 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int[] aArr = new int[45];
		int[] bArr = new int[45];
		
		aArr[0] = 0;
		aArr[1] = 1;
		bArr[0] = 1;
		bArr[1] = 1;
		
		for(int i=2; i<45; i++) {
			aArr[i] = aArr[i-2] + aArr[i-1];
			bArr[i] = bArr[i-2] + bArr[i-1];
		}
		System.out.println(aArr[K-1] + " " + bArr[K-1]);
	}
}
