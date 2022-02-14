import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1388번: 바닥장식
public class BOJ_1388 {
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//2D배열 생성
		String[][] arr = new String[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j]= s.substring(j,j+1); //substring(시작위치, 끝위치+1)로 자르기
			}
		}
		
		//판자의 최대개수
		int cnt=N*M; 
		
		//가로(-)검색
		for(int i=0; i<N; i++) {
			for(int j=0; j<M-1; j++) {
				if (arr[i][j].equals(arr[i][j+1])&& arr[i][j].equals("-")){ 
					cnt--;
				}
			}
		}
		//세로(|)검색
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M; j++) {
				if (arr[i][j].equals(arr[i+1][j])&& arr[i][j].equals("|")){ 
					cnt--;
				}
			}
		}
		System.out.println(cnt);
	}
}