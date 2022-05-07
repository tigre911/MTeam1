package baek.feb_28_binary_search;

import java.io.*;
import java.util.*;

public class BOJ_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NC = reader.readLine().split(" ");
        int N = Integer.parseInt(NC[0]);
        int C = Integer.parseInt(NC[1]);
        int[] position = new int[N];

        for(int i=0; i<N; i++){
            position[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(position);

        System.out.println(findAnswer(position, C));
    }

    static int findAnswer(int[] position, int C){
        int left = 0;
        int right = 1_000_000_000;
        int center = 0;
        int answer = 0; //계산 과정에서 중앙값을 임시 저장할 변수

        while(left<=right){
            center = (left+right)/2; //중앙값 설정

            int count = 1;
            int start = position[0];
            for(int i=1; i<position.length; i++){
                if(position[i]-start>=center){
                    start = position[i];
                    count++;
                }
            }
            if(count>=C){ //설치가능 갯수가 요구 갯수 이상일 때
                          //count>C인 경우 : 설정한 중앙값이 최대값보다 명백하게 작음
                          //count==C인 경우 : 이번의 중앙값이 최대값일 수 있지만 
                          //                 조건에 해당되는 더 큰 값이 있을 수도 있으므로 
                          //                 중앙값이 변하지 않을 때까지 계속 계산함.
                          //                 만약 이후의 모든 계산에서 count<C라면
                          //                 이번에 임시 저장한 answer는 자동으로 최대값이 됨
                answer = center;
                left = center+1; //중앙값 미만으로도 count>=C를 만족할 수 있지만 찾는 값이 최대값이므로 고려하지 않음
            }else{ //간격이 임의값이 되도록 C개 이상으로 설치가 불가능 할 때(임의값이 최대값의 범위를 초과함)
                right = center-1;
            }
        }

        return answer;
    }
}

/*
    집 갯수 : N
    공유기 갯수 : C
    문제 조건 하에서 최대 거리 1_000_000_000 : int 가능
    집의 좌표들로 거리가 임의의 수 A이상인 C-1개의 조합을 생성 가능하다면 정답 후보임
        범위가 너무 크다? 이분탐색 가즈아
*/