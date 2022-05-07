import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18353_병사_배치하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int N = Integer.parseInt(br.readLine());
	       
	       int[] soldiers = new int[N+1];
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       for(int i=1; i<=N; i++) {
	    	   soldiers[i] = Integer.parseInt(st.nextToken());
	       }
	       
	       int[] dp = new int[N+1];
	       Arrays.fill(dp, 1);
	       
	       for(int i=1; i<=N; i++){
	            for(int j=1; j<i; j++){
	                if(soldiers[j]> soldiers[i]){
	                    dp[i] = Math.max(dp[j]+1, dp[i]);
	                }
	            }
	        }
	        Arrays.sort(dp);

	        System.out.println(N-dp[N]);
	}
}
