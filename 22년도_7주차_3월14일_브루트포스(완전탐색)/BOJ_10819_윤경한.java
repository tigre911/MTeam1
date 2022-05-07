package baek.march_14_brute;

import java.util.Scanner;

public class BOJ_10819 {
    static int N;
    static int big;
    static int[] arr;
    static int[] nums;
    static boolean[] isUsed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        nums = new int[N];
        isUsed = new boolean[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        makeArr(0);
        System.out.println(big);
    }
    static void makeArr(int inputIdx){
        if(inputIdx>=N){
            int sum = 0;
            for(int i=1; i<N; i++){
                sum += Math.abs(arr[i-1]-arr[i]);
            }
            if(sum>big){
                big = sum;
            }
            return;
        }

        for(int i=0; i<N; i++){
            boolean canAdd = true;
            int scanIdx = 0;
            while(scanIdx<inputIdx){
                if(arr[scanIdx]==nums[i]){
                    if(isUsed[i]){
                        canAdd = false;
                        break;
                    }
                }
                scanIdx++;
            }
            if(canAdd){
                arr[inputIdx] = nums[i];
                isUsed[i] = true;
                makeArr(inputIdx+1);
                isUsed[i] = false;
            }
        }
        
    }
}
