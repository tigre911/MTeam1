package study008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_김다빈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	//	오늘부터 n+1일째 되는 날 퇴사
		
		int[] ti = new int[20];						//	상담 완료 기간 ti
		int[] pi = new int[20];						//	상담 금액 pi
		int[] dp = new int[20];						//	n일에 얻을 수 있는 최대 수익

        for(int i=1; i<=n; i++){
            String[] input = br.readLine().split(" ");	//	split으로 공백 주고 string이라는 배열에 ti pi를 넣어줌
            ti[i] = Integer.parseInt(input[0]);			//	input 의 첫번째
            pi[i] = Integer.parseInt(input[1]);			//	input 의 두번째
        }

        for(int i = n; i>0; i--){					
            if(ti[i]>n-i+1){						//	일할 수 있는날짜를 넘어가는 경우 
                dp[i] = dp[i+1];					//	n일에 얻을 수 있는 최대 수익 
            }else {									//	아닌 경우
                dp[i] = Math.max(pi[i]+dp[i+ti[i]],dp[i+1]);
                /*
                	날짜가 범위를 넘어가지 않는 경우  [금일 상담금액+최대수익(금일+상담완료기간)], 최대수익(하루뒤)
                */
            }
        }

        System.out.print(dp[1]);
		
	}
}
