import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] visited = new boolean[N];
 
        for(int i=0; i<N; i++)
            arr[i] = i+1;
 
        perm(arr, output, visited, 0, N, N);  //n개중 n개 뽑기(nPn)      
    }
 
    // (순열)순서를 지키면서 n 개중에서 r 개를 뽑는 경우 (depth=0에서 시작)(nPr)
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            print(output, r);
            return;
        }
    
        for(int i=0; i<n; i++) {
            if(visited[i] != true) { //방문하지 않았다면
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);   //재귀(depth + 1)
                visited[i] = false; //재초기화
            }
        }
    }
    //배열 출력 메소드
    static void print(int[] arr, int r) {
        for(int i=0; i<r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}