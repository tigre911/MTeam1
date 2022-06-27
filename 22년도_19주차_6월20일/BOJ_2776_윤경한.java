package baek.june_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2776 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(reader.readLine());
            String[] Ns = reader.readLine().split(" ");
            int[] note = new int[N];
            for(int a=0; a<N; a++){
                note[a] = Integer.parseInt(Ns[a]);
            }
            Arrays.sort(note);

            int M = Integer.parseInt(reader.readLine());
            String[] Ms = reader.readLine().split(" ");
            for(String s:Ms){
                int target = Integer.parseInt(s);
                int left = 0;
                int right = N-1;
                int answer = 0;
                do{
                    int center = (left+right)/2;
                    if(note[center]>target){
                        right = center-1;
                    }else if(note[center]<target){
                        left = center+1;
                    }else{
                        answer = 1;
                        break;
                    }
                }while(left<=right);
                writer.write(answer+"\n");
            }
            writer.flush();
        }
    }
}
