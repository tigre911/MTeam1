import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//백준 20186번: 수고르기
public class BOJ_20186 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//배열
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Integer[] arr2 = arr.clone();
		Arrays.sort(arr2,Collections.reverseOrder());
		
		int selected=0;
		int score=0;
		int[] bigidx = new int[K];
		boolean[] visited = new boolean[N];
		
		for(int j=0; j<N; j++) {
			for(int i=0; i<K; i++) {
				if(arr2[i]==arr[j] && visited[j]==false) {
					bigidx[i]=j;  //{1, 3, 0}
					visited[j]=true;  //안쓰면 {1, 3, 3}나옴
				}
			}
		}
		Arrays.sort(bigidx); //{0, 1, 3} 왼쪽에서부터 검색하기 위해 정렬

		for(int i=0; i<K; i++) {
			score += arr[bigidx[i]]-selected;
			selected++;
		}
		
		System.out.println(score);
	}
}
