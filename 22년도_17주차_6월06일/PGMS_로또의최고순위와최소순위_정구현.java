package Algorithm.PGMS.로또의최고순위와최소순위;

public class PGMS_로또의최고순위와최소순위_정구현 {
    public static void main(String[] args) {

    }

}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        int cntWin = 0;
        int cntNull = 0;

        int max = 0;
        int min = 0;

        for(int i = 0; i<6; i++){
            if(lottos[i] == 0)
                cntNull += 1;
            for(int j = 0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    cntWin += 1;
                }
            }
        }

        max = (6-cntWin-cntNull) + 1;

        if(cntNull==6){
            min = 6;
        }else if(cntNull==0){
            min = 6;
            max = 6;
        }
        else{
            min = (6-cntWin) + 1;
        }

        answer = new int[]{max, min};
        return answer;
    }
}