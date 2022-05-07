package study006;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
	문제
	토크나이저로  나눠서 오름차순 정렬 한 뒤,
	4/2==0 이면 4/2-1=1
	
 */

public class BOJ_18310_김다빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        	
        //	버퍼리더로 받은 N길이만큼의 배열 생성
        int[] arr = new int[N];

        //	StringTokenizer  사용해서 입력받은 겂을 " " 공백을 기준으로 나눈다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //	n만큼
        for (int i = 0; i < N; i++) {
            //	배열은 = 입력받은 st값들을 정수로 바꿔준다.
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //	오름차순으로 정렬
        Arrays.sort(arr);

        //	오름 차순 정렬했을 때 {1,5,7,9}
        //	가장 중간에 있는 값이 가장 가까우므로
        //	4/2-1 = 1 arr[1]=5 
        if (N % 2 == 0) {
            System.out.println(arr[N / 2 - 1]);	//	N/2-1
        } else {
            System.out.println(arr[N / 2]);	//	아니면 N/2
        }
    }
}