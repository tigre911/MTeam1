package Algorithm.PGMS.없는숫자더하;

public class PGMS_없는숫자더하기_정구현 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        int answer = 45;
        for(int i=0; i<numbers.length; i++){
            answer += -numbers[i];
        }
    }
}
