package study007;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_김다빈 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int arr[];
    
    //										예외처리
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());	//	상근이의 숫자 카드 개수
        arr = new int[n];						//	상근이가 가진 숫자 카드
        StringTokenizer st = new StringTokenizer(br.readLine());	//	공백 사용

        for(int i = 0 ; i < n; i++)			
            arr[i] = Integer.parseInt(st.nextToken());	//	상근이 카드 숫자 입력

        Arrays.sort(arr);		 // 상근이 숫자 카드 오름차순 정렬

        m = Integer.parseInt(br.readLine());	//	비교할 숫자 카드 개수
        st = new StringTokenizer(br.readLine());//	tokenizer 재사용하기위한 초기화

        for(int i = 0 ; i < m; i++) {			//	비교 숫자 카드 입력
            int num = Integer.parseInt(st.nextToken());
       
            if(binarySearch(num)) bw.write("1 ");	// 이분 탐색을 해서 해당 숫자가 있는 경우
            else bw.write("0 ");					// 이분 탐색을 해서 해당 숫자가 없는 경우
        }

        bw.close();			//	bufferdwrite 닫기
        br.close();			//	bufferdreader 닫기
    }
    private static boolean binarySearch(int num) {	//	찾고자 하는 숫자 num
        int leftIndex = 0;				//	왼쪽 인덱스 초기값 0
        int rightIndex = n - 1;			//	오른쪽 인덱스 초기값 상근이숫자카드 -1;

        while(leftIndex <= rightIndex){	//	오른쪽 인덱스 값이 더 큰 경우
            int midIndex = (leftIndex + rightIndex) / 2;	//	인덱스 가운데 값
            int mid = arr[midIndex];						//	인덱스 가운데 위치

            if(num < mid) rightIndex = midIndex - 1;		//	ex) 가운데값-1 왼쪽0~8오른쪽  가운데 값 4일때, num이 더 작으면 right=mid-1 => 즉 index 절반 0~3으로 됨 
            else if(num > mid) leftIndex = midIndex + 1;	//	ex) 가운데값+1 왼쪽0~8오른쪽  가운데 값 4일때, num이 더 크면   left =mid+1 => 즉 index 절반 5~8로 됨
            else return true;								//	값이 일치하면 리턴해줌
        }
        return false;
    }
}
