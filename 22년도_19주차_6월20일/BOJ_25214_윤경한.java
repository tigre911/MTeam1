package baek.june_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_25214 {
    public static void main(String[] args) throws Exception {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        String[] nStr = reader.readLine().split(" ");
        int[] ns = new int[N];
        for(int i=0; i<N; i++){
            ns[i] = Integer.parseInt(nStr[i]);
        }

        int big = ns[0];
        int small = ns[0];
        int tmp = 0;
        for(int n:ns){
            if(big<n){
                big = n;
                tmp = Math.max(big-small, tmp);
            }else if(n<small){
                tmp = Math.max(tmp, big-small);
                small = big = n;
            }
            writer.write(""+tmp+" ");
        }
        writer.flush();
    }
}
