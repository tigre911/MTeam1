package Algorithm.BaekjoonOnlineJudge.BOJ_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10814_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        //정렬
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[]o1, String[]o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        //입력값을 보면 정수와 문자가 있다.
        // 하지만 배열에 입력받으려면 둘중 문자열로 받아야 하기때문에 문자열로 받고 정수형으로 형변환을 해줘야한다.
        // o1과 o2의 차를 리턴하게되면, 차가 음수 또는 양수가 나오게 되면 두 값의 위치를 바꾸고, 같다면 바꾸지 않을 것이다.
        //위 코드를 적용하면 원하는 오름차순 정렬을 얻을 수 있다.

        //sb에 정렬된 배열을 순서대로 저장해준다.
        for(int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}

//이차원 배열과 정렬을 사용해 풀 것이다.
//이차원 배열에 입력값을 넣고, 나이를 오름차 순으로 정렬하되, 같은 나이일 경우 입력된 순서대로 정렬해야 한다.
//그렇다면 입력된 그대로 나이만 정렬하면 된다.
//배열을 정렬하는 함수인 Arrays.sort를 사용해 정렬을 할 것이고, comparator의 compare을 override해서 배열의 행과 열중 행에 맞춰서 정렬해 줄 것이다.
