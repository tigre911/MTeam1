import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	       
	    int[][] arr = new int [N+1][2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());	//상담기간
			arr[i][1]=Integer.parseInt(st.nextToken()); //돈
		}
		ArrayList<Integer> cashArr = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			int cash=0;
			days(cashArr, arr, i, cash,N);
		}
		Collections.sort(cashArr, Collections.reverseOrder());
		System.out.println(cashArr.get(0));
	}
	public static void days(ArrayList<Integer> cashArr,int[][] arr,int i, int cash,int N) {
			while(i>N || i+arr[i][0]>N+1) {
				cash += arr[i][1];
				cashArr.add(cash);
				days(cashArr, arr, i+arr[i][0], cash, N);
				i++;
			}
	}
}
