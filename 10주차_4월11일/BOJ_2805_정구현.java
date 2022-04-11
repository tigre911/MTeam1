package Algorithm.BaekjoonOnlineJudge.BOJ_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2805_정구현{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] inputArray = br.readLine().split(" ");

            int treeCount = Integer.parseInt(inputArray[0]); // 나무의 수
            int minLengthTree = Integer.parseInt(inputArray[1]); // 적어도 가져가야할 나무의 길이


            String[] preTreeArray = br.readLine().split(" ");
            int[] treeArray = new int[treeCount]; // 나무 높이들의 배열
            for(int i=0; i<preTreeArray.length; i++){
                treeArray[i] = Integer.parseInt(preTreeArray[i]);
            }
            Arrays.sort(treeArray); // 오름차순으로 정렬
            int lastInt = treeArray[treeCount-1];

            int maxHeight = lastInt; // 톱날의 최대 높이
            int minHeight = 0; // 톱날의 최소 높이
            int middle = 0;

            while(maxHeight >= minHeight){
                middle = (minHeight+maxHeight)/2;

                int cutTree = 0; // 톱날로 나무를 잘랐을 때 남은 나무 길이
                long sumCutTree = 0; // 잘라낸 나무 길이들의 합, long을 선언한 이유는 합이 int 범위를 넘어갈 수도 있다.

                for(int j=0; j<treeArray.length; j++){

                    cutTree = treeArray[j] - middle; // 이분탐색으로 적절한 톱날의 높이를 찾아간다. 중간 값으로 나무들을 잘라보고
                    // 범위를 좁혀나간다.

                    if(cutTree <0){
                        cutTree = 0; // 잘린게 없으면 0이기 때문에 마이너스 값은 존재할 수 없다.
                    }
                    sumCutTree += cutTree;
                }

                if(sumCutTree >= minLengthTree){ // 톱으로 잘라낸 나무 길이들의 합이 최소한으로 가져가야되는 나무 길이보다 클 때

                    minHeight = middle + 1; // 환경을 생각해서 딱 맞춰 잘라가려면 톱날의 높이를 높여서 나무를 조금만 잘라가야 한다.

                }else if(sumCutTree < minLengthTree){ // 톱으로 잘라낸 나무 길이들의 합이 최소한으로 가져가야 되는 나무 길이보다 작을 때

                    maxHeight = middle - 1; // 필요한 나무길이보다 잘라낸 나무 길이들의 합이 작기 때문에 톱날의 높이를 낮춰서 더 길게 베어야 한다.

                }

            }

            System.out.println(maxHeight);    // 톱날의 높이를 설정할 수 있는 높이에서 최대값
        }
}
