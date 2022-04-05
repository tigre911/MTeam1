package week11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644 {
	static List<Integer>[] relation;
	static boolean[] checked;
	static int res = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		relation = new ArrayList[n+1];
		checked = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			relation[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken()); // 비교할 사람
		int num2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine()); // 관계의 개수
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 부모
			int y = Integer.parseInt(st.nextToken()); // 자식
			// 방향이 없는 양방향 그래프
			relation[x].add(y);
			relation[y].add(x);
		}
		// 시작 정점, 끝 정점, 촌 수
		dfs(num1,num2, 0);
		System.out.println(res);
	}
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return; 
		}
		
		checked[start] = true;
		for(int i=0; i<relation[start].size(); i++) { 
			int next = relation[start].get(i); // i번째의 값을 가져온다
			if(!checked[next]) { // 방문처리 되지 않으면
				dfs(next, end, cnt+1); // 시작점을 바꾸고 다음 촌수로 이동
			}
		}
	}
}
