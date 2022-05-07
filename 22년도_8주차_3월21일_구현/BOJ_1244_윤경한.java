package baek.march_21_impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchNum = Integer.parseInt(reader.readLine());
        int[] switches = new int[switchNum+1];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for(int i=1; i<=switchNum; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(reader.readLine());

        for(int i=0; i<studentNum; i++){
            st = new StringTokenizer(reader.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(gender==1){
                male(switches, n);
            }else{
                female(switches, n);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<switches.length; i++){
            if(i%20==0){
                sb.append(switches[i]+" \n");
            }else{
                sb.append(switches[i]+" ");
            }
        }
        writer.write(sb.toString());
        writer.flush();
    }
    static void male(int[] switches, int n){
        for(int i=n; i<switches.length; i+=n){
            switches[i] ^= 1;
        }
    }
    static void female(int[] switches, int n){
        int leftIdx = n-1;
        int rightIdx = n+1;
        switches[n] ^= 1;

        while(leftIdx>0 && rightIdx<switches.length){
            if(switches[leftIdx]==switches[rightIdx]){
                switches[leftIdx--] ^= 1;
                switches[rightIdx++] ^= 1;
            }else{
                break;
            }
        }
    }
}
