package baek.july_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_25212 {
    static double[] c;
    static double sum;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        c = new double[N];
        String[] s = reader.readLine().split(" ");
        for(int i=0; i<N; i++){
            c[i] = 100/Double.parseDouble(s[i]);
        }
        make(0);
        System.out.println(answer);
    }
    static void make(int idx){
        if(sum>=99){
            if(sum<=101){
                answer++;
            }
            return;
        }
        for(int i=idx; i<c.length; i++){
            sum += c[i];
            make(i+1);
            sum -= c[i];
        }
    }
}
