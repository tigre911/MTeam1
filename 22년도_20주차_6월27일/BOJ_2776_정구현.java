package Algorithm.BaekjoonOnlineJudge.BOJ_2776;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        //정수를 담을 수첩
        //HashSet 사용 이유 : 중복 제거 및 contains함수 사용하여 값 탐색
        HashSet<Integer> note = new HashSet<>();

        for(int i = 0; i<T; i++){
            //테스트 케이스 시작때마다 초기화
            note.clear();

            //첫번째 수첩 정수 갯수
            int N = Integer.parseInt(br.readLine());

            //정수 값 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                note.add(Integer.parseInt(st.nextToken()));
            }

            //두번째 수첩 정수 갯수
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                //해당 값이 있으면 1반환
                if (note.contains(tmp)) {
                    bw.write("1\n");
                } else {//없으면 0반환
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
