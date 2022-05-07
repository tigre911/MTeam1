package baek.march_14_brute;

import java.util.Scanner;

public class BOJ_10974 {
    static int N;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N]; //각 줄마다 출력될 배열
        makeArr(0);
    }
    static void makeArr(int inputIdx){ //nums에 대해 인덱스를 1씩 늘려가며 검사&추가
        if(inputIdx>=N){ //이번 인덱스가 수의 갯수 N과 같다면 수열이 완성되었다는 뜻임
            String arrStr = "";
            for(int tmp:nums){
                arrStr += tmp+" ";
            }
            System.out.println(arrStr);
            return;
        }

        for(int i=1; i<=N; i++){
            boolean canAdd = true;
            int scanIdx = 0;
            while(scanIdx<inputIdx){ //수열에서 이번 인덱스 이전의 수들을 차례로 검사
                                     //이번 인덱스가 0이라면 검사할 필요가 없으므로 실행X
                if(nums[scanIdx]==i){ //넣으려는 숫자가 수열에 이미 있다면
                    canAdd = false; //숫자를 추가하지 못하게 변수 설정
                    break;
                }
                scanIdx++;
            }
            if(canAdd){ //추가할 숫자가 수열에 없었다면
                nums[inputIdx] = i; //숫자를 추가
                makeArr(inputIdx+1); //다음 인덱스도 위와 같이 검사&추가 절차를 수행
            }
        }
    }
}
