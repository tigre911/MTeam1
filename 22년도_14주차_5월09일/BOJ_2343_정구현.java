package Algorithm.BaekjoonOnlineJudge.BOJ_2343;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2343_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int high = 0;
        int low = 0;
        int mid;
        st = new StringTokenizer(br.readLine());


        //배열에 강의 넣기
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
            low = Math.max(arr[i], low);
        }

        while (low<=high){
            int temp = 0;
            int cnt = 0;

            mid = (high+low)/2;

            for(int i : arr){
                if(temp + i > mid){
                    temp = 0;
                    cnt++;
                }
                temp+=i;
            }

            if(temp != 0) cnt++;

            if(cnt<=M){
                high = mid -1;
            } else{
                low = mid +1;
            }

        }

        bw.write(low + "");
        bw.flush();
        br.close();
        bw.close();

    }
}
