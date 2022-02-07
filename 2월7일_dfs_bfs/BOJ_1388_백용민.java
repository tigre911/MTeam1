package yes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388_백용민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[2];
        int p = 0;

        while (stt.hasMoreTokens()) {
            num[p++] = Integer.parseInt(stt.nextToken());
        }

        int[][] arr = new int[num[0]][num[1]];
        String input = "";

//        System.out.println(Arrays.toString(num));
        for (int i = 0; i < num[0]; i++) {
            input = br.readLine();
            char[] charArr = input.toCharArray();
//            System.out.println(Arrays.toString(charArr));
            for (int j = 0; j < num[1]; j++) {
                if (charArr[j] == ('-')) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 2;
                }
            }
        }

//        System.out.println(Arrays.deepToString(arr));

        System.out.println(countSum(arr, 1) + countSum(rotate(arr), 2));
    }

    static int[][] rotate(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];


        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }
        return rotate;
    }

    static int countSum(int[][] arr, int num) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != num) {
                    flag = false;
                } else if (arr[i][j] == num && flag == false) {
                    count++;
                    flag = true;
                }
            }
        }

        return count;
    }
}
