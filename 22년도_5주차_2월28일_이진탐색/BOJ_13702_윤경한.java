package baek.feb_28_binary_search;

import java.io.*;

public class BOJ_13702 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] maks = new int[N];

        for(int i=0; i<N; i++){
            maks[i] = Integer.parseInt(reader.readLine());
        }

        long answer = binarySearch(maks, K);

        System.out.println(answer);
    }

    public static long binarySearch(int[] maks, int K){
        long left = 0;
        long right = Integer.MAX_VALUE;
        long center = 0;
        long count = 0;
        long answer = 0;
        while(left<=right){
            center = (left+right)/2;
            count = countSum(maks, center);

            if(count>=K){
                answer = center;
                left = center+1;
            }else{
                right = center-1;
            }
        }   
        return answer;
    }
    
    public static int countSum(int[] maks, long center){
        int count = 0;

        for(int each:maks){
            if(each>0){
                count += each/center;
            }
        }

        return count;
    }
}
/*
    막걸리 수 = N / 사람 수 = K
    항상 N<=K
    용량 A : 0 <= A <= 2^31-1
    나눌 용량 : 1부터? 비효율
        이분탐색? 그럴듯함
            특정 값으로 막걸리들을 나누어 몫을 누적
                누적값 > 사람수 : 값이 최대용량보다 작음 : 더 큰값으로 나눔
                누적값 < 사람수 : 값이 최대용량보다 큼 : 더 작은값으로 나눔
                누적값 = 사람수 : 이때 [center<=최대용량<=right]
                
    ★중요★
    문제 조건하에서 right의 최초 값은 int의 최대값. 
    따라서 29행의 left+right는 오버플로우 가능성 있음
*/