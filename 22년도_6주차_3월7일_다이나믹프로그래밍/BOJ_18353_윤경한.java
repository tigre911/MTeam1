package baek.march_7_dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_18353 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] power = new int[N];
        String[] ps = reader.readLine().split(" ");
        
        for(int i=0; i<N; i++){
            power[i] = Integer.parseInt(ps[i]);
        }

        int[] rLis = new int[N];
        int last = 0;

        rLis[0] = power[0];

        for(int i=1; i<N; i++){
            if(rLis[last]>power[i]){
                //1. rLis의 마지막 값(최소값)보다 새 값이 작을 때
                //새 값을 새로운 최소값으로 넣고 마지막 위치를 1 증가
                rLis[++last] = power[i];
            }else if(rLis[last]==power[i]){
                //2. 내림차순인 수열에서 마지막 값(최소값)과 새 값이 같다면
                //어디에 값을 넣어도 내림차순이 아니게 되므로 아무런 작업도 하지 않음
            }else{
                //3. 위의 두 경우가 아닐 때, 즉 마지막 값이 새 값보다 작을 때
                //내림차순을 만족하게 하는 새 값의 위치를 찾음
                int location = bsForLis(rLis, last, power[i]);
                rLis[location] = power[i];
            }
        }
        System.out.println(N-last-1);
    }
    static int bsForLis(int[] rLis, int last, int target){
        int left = 0;
        int right = last;
        int center = 0;
        int location = 0;

        while(left<=right){
            center = (left+right)/2;

            if(rLis[center]==target){
                location = center;
                break;
            }else if(rLis[center]>target){
                left = center+1;
            }else{
                //rLis[center]<target
                location = center;
                right = center-1;
            }
        }
        return location;
    }
}
/*
    문제의 병사들은 정렬하지 않음.
    전투력은 반드시 내림차순.
    남아있는 병사의 수는 최대로.
    -> 최장 증가 수열(LIS)의 반대로 최장 감소 수열을 찾아야 함.
*/