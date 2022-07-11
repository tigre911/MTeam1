package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// ‘수첩1’에 있으면 1을, 없으면 0을 출력하는 프로그램
// 첫째 줄에 테스트케이스의 개수 T

// 다음 줄에는 ‘수첩 1’에 적어 놓은 정수의 개수 N(1 ≤ N ≤ 1,000,000)
// 그 다음 줄에  ‘수첩 1’에 적혀 있는 정수들이 N개

// 그 다음 줄에는 ‘수첩 2’에 적어 놓은 정수의 개수 M(1 ≤ M ≤ 1,000,000)
// 다음 줄에 ‘수첩 2’에 적어 놓은 정수들이 입력으로 M개


public class BOJ_2776_신수진 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        HashSet<Integer> note = new HashSet<>();
        
        for(int i=0; i<T; i++){
            note.clear();

            // 수첩1 정수 갯수
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                note.add(Integer.parseInt(st.nextToken()));
            }

            // 수첩2 정수 갯수
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(note.contains(tmp)){
                    bw.write("1\n");
                } else{
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
