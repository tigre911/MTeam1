import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16960_김혜영 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 연결램프 0개 가능
		//스위치 N, 램프 M
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //스위치
		int M = Integer.parseInt(st.nextToken()); //램프
		
		//map(switchNum, 배열)따로 담고, lamp배열 숫자체크
		Map<Integer, int[]> hm = new HashMap<>();
		int[] lamps = new int[M+1];
		
		//스위치 정보
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int lampNum = Integer.parseInt(st.nextToken()); //연결된 램프의 수
			int[] arr = new int[lampNum];
			
			for(int j=0; j<lampNum; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
				lamps[arr[j]]++;
			}
			hm.put(i, arr);			
		}
		
		for(int i=1; i<M+1; i++) {
			if(lamps[i]==0) {
				System.out.println(0);
				System.exit(0);
			}
		}
		for(int i=1; i<=N; i++) { //스위치 1개씩 빼면서 체크
			int[] arr2 = hm.get(i);
			boolean chk = true;

			for(int j=0; j<arr2.length; j++) {
				if(lamps[arr2[j]]-1==0) {
					chk=false;
				}
			}
			
			if(chk) {
				System.out.println(1);
				break;
			}else if(i==N) {
				System.out.println(0);
			}
		}
	}
}
