package baek.apr_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = reader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] trees = Arrays.stream(reader.readLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();

        int left = 0;
        int right = 1_000_000_000;
        int mid = 0;
        int max = 0;

        while(left<=right){
            mid = (left+right)/2;
            long sum = 0;

            for(int tree:trees){
                if(tree>mid){
                    sum += tree-mid;
                }
            }
            if(sum>=M){
                max = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(max);
    }
}
