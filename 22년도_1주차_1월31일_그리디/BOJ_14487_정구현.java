package Algorithm.BaekjoonOnlineJudge.BOJ_14487;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14487 {
    public static void main(String[] args) throws IOException {
        //buffered Reader/Writer를 이용한 데이터 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //마을의 수
        int n = Integer.parseInt(st.nextToken());

        int result = 0;

        ArrayList<Integer> t = new ArrayList<Integer>();
        st =new StringTokenizer(br.readLine());

        //모든 마을의 이동비용을 result에 더한다.
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(st.nextToken());
            t.add(i,  j);
            result += t.get(i);
        }

        //그중 이동비용이 가장 높은 지역을 출발지로 선택하여 결과값에서 제거해준다.
        result-= Collections.max(t);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
