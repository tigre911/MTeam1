package baek.feb_21_sort;

import java.io.*;
import java.util.*;

public class BOJ_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        PriorityQueue<Long> pQueue = new PriorityQueue<>(N);

        for(int i=0; i<N; i++){
            pQueue.offer(Long.parseLong(reader.readLine()));
        }
        long sum = 0; //합친수 총합(이전결과 누적)
        long plus = 0;
        for(int size=pQueue.size(); size>1; size--){
            plus = pQueue.poll()+pQueue.poll();
            sum += plus;
            pQueue.offer(plus);
        }
        
        System.out.println(sum);
    }
}
/*

    끝 = 합칠수 없을때 = 1개만 남을때
    수량 무조건 1개씩 감소
    최소 = 큰 수 먼저 합치면 계속 남아 손해 = 최소 수만 골라서?
    정렬? 합친수 재사용탓에 매번 정렬필요 = 매우 비효율
    최소 수 두개 합침 = 합친수 다시 최소판별 대상

    최악 = 1000짜리 100000개 = int?

    행복유치원을 잊지말자
*/