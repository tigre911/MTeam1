package Algorithm.BaekjoonOnlineJudge.BOJ_10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_정구현 {
    //전역 변수 선언
    static int N;
    static boolean[] visited;
    static int[] temp,arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N]; //방문여부
        temp = new int[N]; //N까지의 임시 배열
        arr = new int[N]; //출력할 배열
        for (int i = 0; i < N; i++) {
            temp[i] = i+1;
        }

        permutation(0);
    }


    //for문을 통해 3개의 값을 선택
    //3개의 개수가 다 채워지면 조건문을 통해 빠져나가고 출력을 해준다.
    private static void permutation(int depth) {
        
        //깊이가 N과 같아지면(3개의 개수가 다 채워지면)
        if(depth == N) {
            //for문을 이용하여 출력해준다.
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        
        //for문을 통해 3개의 값을 선택해준다.
        for (int i = 0; i < N; i++) {
            //방문여부 확인
            if(visited[i]) {
                continue;
            }
            
            //방문여부 표시
            visited[i] = true;
            
            //출력할 배열에 해당 값 저장
            arr[depth] = temp[i];
            
            //재귀 함수 호출
            permutation(depth+1);
            
            //출력이 끝나고 방문 초기화
            visited[i]=false;
        }
    }
}
