package Algorithm.BaekjoonOnlineJudge.BOJ_13164;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_13164 {
    public static void main(String[] args) throws IOException {
        //buffered Reader/Writer를 이용한 데이터 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //원생의 수 N, 조의 개수 K 선언
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //원생들의 키를 담는 배열 선언
        ArrayList<Integer> arr = new ArrayList<Integer>(N);

        //인접한 원생들의 키 차이를 담는 배열 선언
        ArrayList<Integer> diff = new ArrayList<Integer>(N-1);

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }


        //인접한 원생의 키차이를 계산하여 저장
        for (int i = 0; i < N - 1; i++) {
            diff.add(i, arr.get(i + 1) - arr.get(i));
        }

        //키차이가 적은 순(오름차순)으로 정렬한다.
        Collections.sort(diff);

        int result = 0;


        //k개의 그룹을 만들기 위해 N-K번 결과값을 합친다.
        for (int i = 0; i < N - K; i++) {
            result += diff.get(i);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

//public class BOJ_13164 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int [] arr = new int[N];
//        int[] diff = new int[N-1];
//
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 0; i < N - 1; i++) {
//            diff[i] = arr[i+1] - arr[i];
//        }
//        Arrays.sort(diff);
//
//        int result = 0;
//
//        for (int i = 0; i < N - K; i++) {
//            result += diff[i];
//        }
//
//        bw.write(result + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}