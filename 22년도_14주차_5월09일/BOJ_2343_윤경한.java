package baek.may_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2343 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = reader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] lecStr = reader.readLine().split(" ");
        int[] lecture = new int[N];
        int left = 0;
        for(int i=0; i<N; i++){
            lecture[i] = Integer.parseInt(lecStr[i]);
            left = Math.max(left, lecture[i]);
        }
        int right = 1_000_000_000;
        int center = 0;

        while(left<=right){
            center = (left+right)/2;
            int cnt = 1;
            int sum = 0;
            for(int l:lecture){      
                sum += l;
                if(sum>center){
                    cnt++;
                    sum = l;       
                }
            }

            if(cnt>M){
                left = center+1;
            }else{
                right = center-1;
            }
        }
        System.out.println(left);
    }
}
