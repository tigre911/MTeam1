package Algorithm.BaekjoonOnlineJudge.BOJ_17485;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17485_정구현 {
    static int n, m;
    static int fuel[][];
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = new int[n][m];
        dp = new int[3][n][m];

        //연료 배열 초기화
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                fuel[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //탐색 초기값 초기화
        for(int i = 0; i<m; i++){
            dp[0][0][i] = fuel[0][i];
            dp[1][0][i] = fuel[0][i];
            dp[2][0][i] = fuel[0][i];
        }

        for(int i = 0; i<n; i++){
            //맨 왼쪽 끝에서 왼쪽 대각선 방향에서 온 경우
            dp[0][i][0] = Integer.MAX_VALUE;
            //맨 오른쪽 끝인데 오른쪽 대각선 방향에서 온 경우
            dp[2][i][m-1] = Integer.MAX_VALUE;
        }

        //연료 계산
        for(int i=1; i<n; i++){
            for(int j = 0; j<m; j++){
                //현재 위치 기준 왼쪽과 오른쪽 대각선 모두 올 수 있는 경우
                if(checkPosition(j-1) && checkPosition(j+1)){

                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + fuel[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + fuel[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + fuel[i][j];

                } else if(!checkPosition(j-1) && checkPosition(j+1)){

                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + fuel[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + fuel[i][j];

                } else if(checkPosition(j-1) && !checkPosition(j+1)){

                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + fuel[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + fuel[i][j];

                }

            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<3; j++){
                min = min>dp[j][n-1][i] ? dp[j][n-1][i] : min;
            }
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }


    public static boolean checkPosition(int position){
        if(position<0||position>=m)
            return false;
        else
            return true;
    }
}
