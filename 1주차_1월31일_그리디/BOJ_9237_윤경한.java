package baek;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_9237 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        reader.readLine();
        String[] arr = reader.readLine().split(" ");
        Integer[] days = new Integer[arr.length];
        for(int i=0; i<days.length; i++){
            days[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(days, Collections.reverseOrder());
        int passed = 1;
        int tmp = 0;
        for(int n:days){
            passed++;
            tmp--;
            if(tmp<n){
                tmp = n;
            }
        }
        writer.write((passed+tmp)+"");
        writer.close();
    }
}
