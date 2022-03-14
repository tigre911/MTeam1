package Algorithm.BaekjoonOnlineJudge.BOJ_10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_정구현 {
    //전역 변수 선언
    static int N; //N까지의 수
    static boolean[] visited; // 방문여부 체크하는 배열
    static int[] temp,arr; // temp : 각 자리수의 숫자를 저장하는 임시 배열
                            // arr : 출력할 숫자를 담을 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1) 각 배열의 값 초기화
        visited = new boolean[N];
        temp = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = i+1;
        }

        // 2) 순열 재귀함수 탐색
        permutation(0);
    }


    //for문을 통해 3개의 값을 선택
    //3개의 개수가 다 채워지면 조건문을 통해 빠져나가고 출력을 해준다.
    private static void permutation(int depth) {
        
        // 9) 깊이가 N과 같아지면(3개의 개수가 다 채워지면)
        if(depth == N) {
            // 10) for문을 이용하여 출력해준다.
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        
        // 3) for문을 통해 3개의 값을 선택해준다.
        for (int i = 0; i < N; i++) {
            // 4) 방문여부 확인 이미 방문한 인덱스면 통과한다.
            if(visited[i]) {
                continue;
            }
            
            // 5) 방문여부 처리
            visited[i] = true;
            
            // 6) 출력할 배열에 방문한 해당 값 저장
            arr[depth] = temp[i];
            
            //7) 재귀 함수 실행 -> 다음 레벨 탐색
            permutation(depth+1);
            
            // 8) 더이상 방문할 값이 없을때(depth == N) 출력이 끝나고 방문 초기화
            visited[i]=false;
            
        }
    }
}
