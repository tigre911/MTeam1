package baek.feb_21_sort;

import java.io.*;
import java.util.*;

public class BOJ_20186 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] ns = reader.readLine().split(" ");
        int[] nums = Arrays.stream(ns).mapToInt(x->Integer.parseInt(x)).sorted().toArray();
        
        int KK = K;
        int sum = 0;
        int sumMinus = 0;
        for(int i=N-1; KK>0; KK--,i--){
            sum += nums[i];
        }

        while(K>0){
            sumMinus += --K;
        }

        System.out.println(sum-sumMinus);
    }
}
