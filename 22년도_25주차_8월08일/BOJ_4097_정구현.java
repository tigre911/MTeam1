package Algorithm.BaekjoonOnlineJudge.BOJ_4097;

import java.util.*;
import java.io.*;

public class BOJ_4097_Á¤±¸Çö {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N==0) break;

            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken());

                sum += number;
                max = Math.max(max, sum);

                if(sum<0) sum = 0;
            }
            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}