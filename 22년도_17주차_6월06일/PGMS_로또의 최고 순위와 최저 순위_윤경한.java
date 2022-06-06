package baek.june_6;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int z = 0;
        int m = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int wn:win_nums){
            set.add(wn);
        }
        for(int mn:lottos){
            if(mn==0){
                z++;
            }else if(set.contains(mn)){
                m++;
            }
        }
        int[] answer = {Math.min(7-m-z, 6), Math.min(7-m, 6)};
        return answer;
    }
}
