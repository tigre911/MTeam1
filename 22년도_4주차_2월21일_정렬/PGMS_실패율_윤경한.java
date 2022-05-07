package baek.feb_21_sort;

import java.util.*;

public class PGMS_failure {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] answer = solution(N, stages);
        System.out.println(Arrays.toString(answer));
    }
    static class Info {
        int stage;
        double failRate;
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stay = new int[N+1]; // 각 스테이지에 머물러 있는 플레이어 수
                                   // ex)stay[3]은 4스테이지에 몇 명이 있는지 나타냄
        Info[] info = new Info[N];
        for(int i=0; i<N; i++){
            info[i] = new Info();
            info[i].stage = i+1;
        }

        for(int s:stages){
            stay[s-1]++;
        }

        int reached = stages.length;

        for(int i=0; i<N; i++){
            info[i].failRate = (double)stay[i]/reached; //도달한 사람이 아무도 없을 경우 NaN이 될 위험이 있음
            reached -= stay[i];
            if(reached<=0){ //모든 유저에 대해 실패율 계산이 끝났다면 NaN 방지를 위해 계산을 멈춤
                break;
            }
        }

        Comparator<Info> comp = (x,y)->{
            int result = 0;
            if(x.failRate==y.failRate){
                result = Integer.compare(x.stage, y.stage);
            }else{
                result = -Double.compare(x.failRate, y.failRate);
            }
            return result;
        };
        Arrays.sort(info,comp);
        for(int i=0; i<N; i++){
            answer[i] = info[i].stage;
        }
        
        return answer;
    }
}
