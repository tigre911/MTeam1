package baek.march_7_dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14501 {
    static int[][] table;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        table = new int[N+1][2];

        for(int i=1; i<table.length; i++){
            String[] TP = reader.readLine().split(" ");
            table[i][0] = Integer.parseInt(TP[0]); //T
            table[i][1] = Integer.parseInt(TP[1]); //P
        }

        
        System.out.println(cal(1));
    }
    static int cal(int n) {
        int maxIncome = 0;
        for(int now=n; now<table.length; now++){
            int sumIncome = 0;

            if(now+table[now][0]-1<=N){
                sumIncome += table[now][1];
                sumIncome += cal(now+table[now][0]);

            }
            if(maxIncome<sumIncome){
                maxIncome = sumIncome;
            }
        }
        return maxIncome;
    }
}
