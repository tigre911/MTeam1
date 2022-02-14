package Algorithm.BaekjoonOnlineJudge.BOJ_1388;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1388_Á¤±¸Çö {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int COL = Integer.parseInt(st.nextToken());
        final int ROW = Integer.parseInt(st.nextToken());

        char graph[][] = new char[COL][ROW];

        int cnt = 0;
        for (int i = 0; i < COL; i++) {
            graph[i] = br.readLine().toCharArray();
            for (int j = 0; j < ROW; j++) {
                if(graph[i][j]=='-'){
                    cnt++;
                    while (j<ROW && graph[i][j] =='-'){
                        j++;
                    }
                }
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(graph[j][i] == '|'){
                    cnt++;
                    while (j < COL && graph[j][i] == '|') {
                        j++;
                    }
                }
            }
        }


        bw.write(cnt+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
