package Algorithm.PGMS.키패드누르기;

public class PGMS_키패드누르기_정구현 {
    public static void main(String[] args) {
        int[] num = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        Solution s = new Solution();
        System.out.println(s.solution(num, "right"));

    }


}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        //왼손과 오른손의 초기 자판위치 지정
        int left = 10;//*
        int right = 12;//#
        for (int num : numbers) {
            if (num == 0) num = 11; //숫자가 0일경우 자판위치 11로 지정
            switch (num % 3) {
                case 0 : //3, 6, 9, 12(#) -> Right
                    answer.append("R");
                    right = num; //오른손 위치 지정
                    break;

                case 1 : //1, 4, 7, 10(*) -> Left
                    answer.append("L");
                    left = num; //왼손 위치 지정
                    break;

                case 2 : //2, 5, 8, 11(0) -> 가운데줄
                    //입력해야 할 숫자와 현재 손가락의 거리 계산
                    //번호간의 거리 계산 = ((현재 번호 - 누를 번호)/3) + ((현재 번호 - 누를 번호)%3)
                    int distanceL = (Math.abs(num-left) % 3) + (Math.abs(num-left) / 3);
                    int distanceR = (Math.abs(num-right) % 3) + (Math.abs(num-right) / 3);


                    if (distanceL < distanceR) {//왼손의 위치가 더 가까울경우
                        answer.append("L");
                        left = num;

                    } else if (distanceR < distanceL) {//오른손의 위치가 더 가까울경우
                        answer.append("R");
                        right = num;
                    } else { //둘의 거리가 같을경우 오른손잡이인지 왼손잡이인지 여부 확인
                        answer.append(hand.equals("right") ? "R" : "L");
                        if (hand.equals("right")) right = num;
                        else left = num;
                    }
                    break;

            }
        }
        return answer.toString();
    }
}


