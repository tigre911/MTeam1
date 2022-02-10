package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14487 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int big = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<n; i++){
            int t = Integer.parseInt(st.nextToken());
            sum += t;
            if(big<t){
                big = t;
            }
        }
        System.out.println(sum-big);
    }
}
