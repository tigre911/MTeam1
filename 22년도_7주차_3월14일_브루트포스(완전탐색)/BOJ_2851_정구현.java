package Algorithm.BaekjoonOnlineJudge.BOJ_2851;

import java.io.*;

public class BOJ_2851_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int result = 0;
        int score[] = new int[10];

        //버섯의 점수를 저장하는 배열 생성
        for (int i = 0; i < 10; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            //버섯의 점수 획득
            sum += score[i];

            /*
                절대값 비교
                i번째와 i-1번째 획득했을때의 점수를 100을 뺀 값을 비교하여
                i번째가 i-1번째보다 100과 더 가까운 수일때 결과에 저장
            */
            if(Math.abs(100-(sum-score[i])) >= Math.abs(100-sum)){
                result=sum;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
