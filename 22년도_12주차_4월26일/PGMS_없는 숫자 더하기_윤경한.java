package baek.apr_26;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        for(int n:numbers){
            sum += n;
        }
        return 45-sum;
    }
}
