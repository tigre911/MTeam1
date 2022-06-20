package Algorithm.BaekjoonOnlineJudge.BOJ_1931;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //회의의 갯수
        int num = Integer.parseInt(st.nextToken());

        //최대 회의 수
        int cnt = 0;

        //이전 회의 종료 시간
        int end_time = 0;

        int[][] arr = new int[num][2];

        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //종료시간이 같을경우 시작시간이 빠른순으로 정렬
        Arrays.sort(arr, (o1, o2)->{
            if(o1[1]==o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        //이전 회의 종료시간이 다음 회의 시작시간보다 작을경우
        for(int i = 0; i<num; i++){
            if(end_time <= arr[i][0]){
                end_time = arr[i][1];
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
