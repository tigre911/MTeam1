package baek.march_14_brute;

import java.util.Arrays;
import java.util.HashSet;

public class PGMS_FindPrime {
    static int lastZero;
    static int[] each;
    static int[] made;
    static boolean[] isUsed;
    static boolean[] composite;
    static HashSet<Integer> primes;
    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
    
    public static int solution(String numbers){
        String[] numStr = numbers.split("");
        Arrays.sort(numStr);
        int t = 1;
        int big = 0;
        each = new int[numStr.length];
        made = new int[each.length];
        isUsed = new boolean[each.length];
        primes = new HashSet<>();

        for(int i=0; i<each.length; i++){
            each[i] = Integer.parseInt(numStr[i]);
            big += each[i]*t;
            t *= 10;
            if(each[i]==0){
                lastZero = i;
            }
        }
        
        composite = new boolean[big+1]; //big까지의 소수 정보를 저장할 배열. 합성수는 true, 소수는 false
        composite[1] = true;
        int sqrt = (int)Math.sqrt(big); //합성수 제거에 필요한 종료점
        
        for(int i=2; i<=sqrt; i++){
            if(!composite[i]){
                for(int ij=i+i; ij<=big; ij+=i){
                    composite[ij] = true;
                }
            }
        }
        int answer = 0;
        answer = findPrime(0, answer);
        return answer;
    }
    static int findPrime(int idx, int answer){
        if(idx>=each.length){
            return answer;
        }
        int point = 0;
        if(each[0]==0 && idx==0){
            point = lastZero+1;
        }

        for(int i=point; i<each.length; i++){
            int scanIdx = 0;
            boolean canAdd = true;
            while(scanIdx<idx){
                if(made[scanIdx]==each[i]){
                    if(isUsed[i]){
                        canAdd = false;
                        break;
                    }
                }
                scanIdx++;
            }
            if(canAdd){
                made[idx] = each[i];
                if(isPrime(idx)){
                    answer++;
                }
                isUsed[i] = true;
                answer = findPrime(idx+1, answer);
                isUsed[i] = false;
            }
        }
        return answer;
    }
    static boolean isPrime(int idx){
        boolean ans = false;
        int t = 1;
        int sum = 0;
        while(idx>=0){
            sum += made[idx--]*t;
            t *= 10;
        }
        
        if(!composite[sum]){
            if(!primes.contains(sum)){
                primes.add(sum);
                ans = true;
            }
        }
        return ans;
    }
}
