package Algorithm.PGMS.소수찾기;

import java.util.ArrayList;

public class PGMS_소수찾기_정구현 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("17"));
    }
}

class Solution {
    //소수의 갯수
    static int answer = 0;

    //numbers 방문 여부 체크하는 배열
    static boolean visited[] = new boolean[7];

    //numbers의 각 자리수로 만들 수 있는 조합을 저장할 ArrayList
    static ArrayList<Integer> arr = new ArrayList<>();

    // 3) numbers의 각 자리수를 조합하기 위한 재귀함수
    public static void recursive(String n, String temp, int length){

        // 11) 현재 조합중인 수의 자리수 == temp에 저장된 자리수 길이 확인
        if(temp.length()==length){
            // 12) 중복값 방지를 위해 ArrayList에 이미 존재하는 값인지 확인
            if (!arr.contains(Integer.parseInt(temp))) {
                arr.add(Integer.parseInt(temp));
                return;
            }
        }

        // 4) n으로 전달 된  numbers를 탐색
        for (int i = 0; i < n.length(); i++) {
            // 5) 방문 체크 이미 방문한 인덱스면 통과한다.
            if (visited[i]) {
                continue;
            }

            // 6) 임시변수 temp에 문자열을 저장하여 숫자 조합
            temp += n.charAt(i);

            // 7) 방문 처리
            visited[i] = true;

            // 8) 재귀 함수 실행 -> 현재 몇자리 수를 만드는지 length 정보를 전달
            recursive(n, temp, length);

            // 9) 조합이 완료되면 직전의 방문처리한 인덱스를 false로 변경
            visited[i] = false;

            // 10) temp 변수에서 마지막 자리의 숫자를 제외하고 갱신
            temp = temp.substring(0,temp.length()-1);
        }

    }

    // 15) 소수 판별 함수
    public static void calcPrimeNumber(int n) {
        // 16) 0과 1은 소수가 아니므로 종료한다.
        if (n == 0 || n == 1)   return;

        // 17) 제곱근으로 나누어 떨어지면 소수가 아니므로 메소드 종료.
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return;
        }

        // 18) 위의 조건을 모두 통과하면 answer의 개수 증가
        answer++;
    }
    public int solution(String numbers) {
        // 1) numbers의 각 자리수를 붙일 임시 변수
        String temp = "";

        // 2) 입력된 값에 대한 자리수에 대한 재귀함수 반복 실행
        for (int i = 1; i <= numbers.length(); i++) {
            recursive(numbers,temp,i);
        }
        // 13) 생성된 모든 값이 담긴 ArrayList를 탐색한다.
        for(int num: arr){
            // 14) 각 정수가 소수인지 확인
            calcPrimeNumber(num);
        }

        return answer;
    }
}
