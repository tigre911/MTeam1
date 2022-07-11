import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2776 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());//테스트케이스 개수 T
		
		for(int i=0; i<T; i++) {
			//HashSet : 중복제거 & 정렬
			Set<Integer> ts = new HashSet<>();
			
			int N = Integer.parseInt(br.readLine());//수첩1 정수 개수 N
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				ts.add(Integer.parseInt(st.nextToken()));
			}
			//System.out.println(ts);
			
			int M = Integer.parseInt(br.readLine());//수첩2 정수 개수 M
			st = new StringTokenizer(br.readLine());
			
			//판별
			for(int j=0; j<M; j++) {
				if(ts.contains(Integer.parseInt(st.nextToken()))){
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