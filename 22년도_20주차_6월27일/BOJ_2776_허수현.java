package week20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2776 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			HashMap<Integer, Boolean> hm = new HashMap<>();
			for(int j=0; j<N; j++) {
				hm.put(Integer.parseInt(st.nextToken()), true);
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				if(hm.containsKey(Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
