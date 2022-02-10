package baek;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        StringTokenizer hs = new StringTokenizer(reader.readLine());
        
        int[] height = new int[N];
        for(int i=0; i<N; i++){
            height[i] = Integer.parseInt(hs.nextToken());
        }
        int[] gap = new int[N-1];
        for(int i=0; i<N-1; i++){
            gap[i] = height[i+1]-height[i];
        }
        //------------------일반적인 유형
        //Arrays.sort(gap);
        //int sum = 0;
        //for(int i=0; i<gap.length-K+1; i++){
        //    sum += gap[i];
        //}

        //------------------스트림 이용
        int sum = Arrays.stream(gap).parallel().sorted().limit(gap.length-K+1).sum();

        writer.write(sum+"");
        writer.flush();
    }
}
