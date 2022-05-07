package baek.feb_28_binary_search;

import java.io.*;


public class BOJ_3896 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());

        boolean[] notPrime = new boolean[1299709+1]; //소수라면 false, 합성수라면 true

        for(int i=2; i<=1140; i++){      
            if(!notPrime[i]){ //해당 수가 소수일 때
                for(int ij=i*2; ij<=1299709; ij+=i){ //범위 내 해당 수의 배수들을 합성수로 표시
                    notPrime[ij] = true;
                }
            }
        }

        int each = 0;
        for(int i=0; i<T; i++){
            each = Integer.parseInt(reader.readLine());
            if(!notPrime[each]){ //each가 소수일 때
                writer.write("0\n"); //포함되는 수열이 없으므로
            }else{ //each가 합성수일 때
                int length = 2; //수열의 길이는 합성수 갯수+1이므로 길이는 최소 2부터 시작
                int left = each-1;
                int right = each+1;
                while(notPrime[left]){
                    length++;
                    left--;
                }
                while(notPrime[right]){
                    length++;
                    right++;
                }
                writer.write(length+"\n");
            }
        }
        writer.flush();
    }
}

/*
    k의 범위 :  1 <= k <= 1299709(100_000번째 소수)
    k를 포함하는 소수 사이 수열이 없는 경우 : k가 소수일 경우
    필요한 수 : 소수들 = 에라토스테네스 체
    배수 제거는 1299709의 제곱근을 int로 변환한(1140) 이하인 수에 대해서만 하면 됨
*/