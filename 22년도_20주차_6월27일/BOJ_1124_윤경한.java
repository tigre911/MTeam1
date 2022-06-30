package baek.june_27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1124 {
    public static void main(String[] args) throws Exception {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] AB = reader.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        boolean[] primes = new boolean[B+1];//true:소수임, false:소수아님
        List<Integer> primeList = new ArrayList<>();
        Arrays.fill(primes, true);
        int jgg = (int)Math.sqrt(B);
        primes[0] = primes[1] = false;

        for(int i=2; i<=jgg; i++){//primes 완성(소수만 남김)
            if(primes[i]){
                for(int j=i*2; j<=B; j+=i){
                    primes[j] = false;
                }
            }
        }
        for(int i=2; i<=B; i++){//소수만 따로 리스트 저장
            if(primes[i]){
                primeList.add(i);
            }
        }

        int answer = 0;
        for(int i=A; i<=B; i++){
            if(!primes[i]){
                int num = i;
                int cnt = 1;
                while(!primes[num]){
                    for(int p:primeList){
                        if(num%p==0){
                            num /= p;
                            cnt++;
                            break;
                        }
                    }
                }
                if(primes[cnt]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
