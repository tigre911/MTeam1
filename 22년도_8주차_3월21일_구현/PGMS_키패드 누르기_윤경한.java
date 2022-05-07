package baek.march_21_impl;

public class PGMS_keypad {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] lHand = {3, 0};
        int[] rHand = {3, 2};

        for(int n:numbers){
            if(n%3==1){
                sb.append("L");
                lHand[0] = n/3;
                lHand[1] = 0;
            }else if(n%3==0 && n!=0){
                sb.append("R");
                rHand[0] = n/3-1;
                rHand[1] = 2;
            }else{
                int row = n==0 ? 3 : n/3;
                int col = 1; 
                int lDist = Math.abs(row-lHand[0])+Math.abs(col-lHand[1]);
                int rDist = Math.abs(row-rHand[0])+Math.abs(col-rHand[1]);

                if(lDist>rDist){
                    sb.append("R");
                    rHand[0] = row;
                    rHand[1] = col;
                }else if(lDist<rDist){
                    sb.append("L");
                    lHand[0] = row;
                    lHand[1] = col;
                }else{
                    if(hand.equals("left")){
                        sb.append("L");
                        lHand[0] = row;
                        lHand[1] = col;
                    }else{
                        sb.append("R");
                        rHand[0] = row;
                        rHand[1] = col;
                    }
                }
            }
        }

        return sb.toString();
    }
}
