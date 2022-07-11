package baek.june_27;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1072 {
    public static void main(String[] args) throws Exception {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] XY = reader.readLine().split(" ");
        int X = Integer.parseInt(XY[0]);
        int Y = Integer.parseInt(XY[1]);
        int Z = (int)((double)Y*100/X);

        long answer = 0;
        long left = X;
        long right = Integer.MAX_VALUE;
        long center;
        do{
            center = (left+right)/2;
            int newZ = (int)((double)(Y+center-X)*100/center);
            if(newZ!=Z){
                answer = center-X;
                right = center-1;
            }else{
                left = center+1;
            }
        }while(left<=right);
        
        System.out.println(answer==0 ? -1 : answer);
    }
}
