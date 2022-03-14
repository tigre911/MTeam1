package Algorithm.BaekjoonOnlineJudge.BOJ_10819;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_정구현 {

    static int N;
    static int[] arr, temp;
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        result = 0;
        temp = new int[N]; // 각순열 케이스를 담아줄 임시 저장소

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0);
        System.out.println(result);
    }

    private static void permutation(int count) {
        //값의 차이의 절대값을 구해줌
        if (count == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }

        //재귀함수 호출 및 방문체크
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            temp[count] = arr[i];
            permutation(count + 1);
            visited[i] = false;
        }
    }
}