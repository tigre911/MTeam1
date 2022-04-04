import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산_01 {
	
	static List<Integer>[] relation;
	static boolean[] checked;
	static int res = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		relation = new List[n+1];
		checked = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			relation[i] = new ArrayList<>();	//배열 인덱스마다 arraylist 생성
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relation[a].add(b);
			relation[b].add(a);
		}
		
		dfs(x,y,0);
		System.out.println(res);
	}
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {	// end와 연결되어있지 않으면 res초기값인 -1 출력
			res = cnt;
			return; 
		}
		
		checked[start] = true;
		for(int i=0; i<relation[start].size(); i++) { 
			int next = relation[start].get(i);
			if(!checked[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}
}