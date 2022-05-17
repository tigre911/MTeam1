package baek.may_17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17485 {
    public static void main(String[] args) throws Exception {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = reader.readLine().split(" ");
        int row = Integer.parseInt(NM[0]);
        int col = Integer.parseInt(NM[1]);
        int[][][] dp = new int[row][col][3];
        int[] dir = {-1, 0, 1};//좌측하단, 하단, 우측하단

        for(int i=0; i<row; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j=0; j<col; j++){
                int num = Integer.parseInt(st.nextToken());
                for(int k=0; k<3; k++){
                    dp[i][j][k] = num;
                }
            }
            dp[i][0][0] = Integer.MAX_VALUE;
            dp[i][col-1][2] = Integer.MAX_VALUE;
        }
        
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<3; k++){
                    int bx = j+dir[k];
                    if(bx<0 || bx>=col){
                        continue;
                    }
                    if(k==0){
                        dp[i][j][k] += Math.min(dp[i-1][bx][1], dp[i-1][bx][2]);
                    }else if(k==1){
                        dp[i][j][k] += Math.min(dp[i-1][bx][0], dp[i-1][bx][2]);
                    }else{//k<3이므로 반드시 k==2
                        dp[i][j][k] += Math.min(dp[i-1][bx][0], dp[i-1][bx][1]);
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int j=0; j<col; j++){
            for(int k=0; k<3; k++){
                answer = Math.min(answer, dp[row-1][j][k]);
            }
        }
        System.out.println(answer);
    }
}
