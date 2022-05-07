package baek.feb_28_binary_search;

import java.io.*;
import java.util.*;

public class BOJ_10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine()); //상근이가 가진 카드의 갯수
        int[] sangCards = new int[N]; //상근이가 가진 카드의 숫자들
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; i++){
            sangCards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(reader.readLine()); //검색할 카드들의 갯수
        int[] compareCards = new int[M]; //검색할 카드의 숫자들
        st = new StringTokenizer(reader.readLine());
        for(int i=0; i<M; i++){
            compareCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sangCards); //이진탐색을 위해 정렬

        for(int card:compareCards){
            writer.write(binarySearch(sangCards, N, card));
        }
        writer.flush();
    }
    static String binarySearch(int[] sangCards, int N, int card){
        int left, right, center;
        left = 0;
        right = N-1;
        do{
            center = (left+right)/2;
            if(card==sangCards[center]){ //비교 대상 카드를 상근이가 가지고 있다면
                return "1 ";
            }else if(card>sangCards[center]){
                left = center+1;
            }else{
                right = center-1;
            }
        }while(left<=right);
        return "0 ";
    }
}
