package baek.feb_21_sort;

import java.io.*;
import java.util.*;

public class BOJ_20186 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0])-1;
        int K = Integer.parseInt(NK[1]);

        String[] ns = reader.readLine().split(" ");
        int[] nums = Arrays.stream(ns).mapToInt(Integer::parseInt).sorted().toArray();
        
        int sum = 0;
        while(K>0){
            sum += nums[N--]-(--K);
        }
        System.out.println(sum);
    }
}
