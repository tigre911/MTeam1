package baek.apr_11;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int remain = rocks.length-n;
        
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;

        while(left<=right){
            int mid = (left+right)/2;
            int possibleCnt = 0;
            int savepoint = 0;

            for(int i=0; i<rocks.length; i++){
                if(rocks[i]-savepoint>=mid){
                    savepoint = rocks[i];
                    possibleCnt++;
                }
            }

            if(possibleCnt>=remain){
                //이번 간격으로 남길 수 있는 바위의 수가 문제의 조건과 같거나 그보다 많을 경우
                answer = mid;
                left = mid+1;
            }else{
                //이번에 설정한 간격으로 남길 수 있는 바위 수가 문제의 조건보다 적은 경우
                //간격을 더 줄여야 하므로 right를 재설정
                right = mid-1;
            }
        }
    
        return answer;
    }
}
/*
    최소값이 가장 크도록 = 공유기 설치?
*/