import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준18310번: 안테나
public class BOJ_18310 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());

	        int[] arr = new int[N];

	        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        for (int i = 0; i < N; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }

	        Arrays.sort(arr);
	        
	        //배열의 중간값 찾기
	        if (N % 2 == 0) { //N이 짝수일 때
	            System.out.println(arr[N / 2 - 1]);
	        } else { //N이 홀수일 때
	            System.out.println(arr[N / 2]);
	        }
	}
}
