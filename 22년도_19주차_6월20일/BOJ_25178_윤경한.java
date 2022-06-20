package baek.june_20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_25178 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = "YES";
        int[] cnta = new int[26];//첫 번째 조건 판별용
        int[] cntb = new int[26];
        Set<Character> set = new HashSet<>();//모음 제거용
        char[] m = {'a', 'e', 'i', 'o', 'u'};
        for(char c:m){
            set.add(c);
        }
        int N = Integer.parseInt(reader.readLine());
        String a = reader.readLine();
        String b = reader.readLine();
        if(a.charAt(0)!=b.charAt(0) || a.charAt(N-1)!=b.charAt(N-1)){//두 번째 조건
            answer = "NO";
        }else{
            char[] aa = a.toCharArray();
            char[] bb = b.toCharArray();
            StringBuilder sba = new StringBuilder();
            StringBuilder sbb = new StringBuilder();
            for(int i=0; i<N; i++){
                cnta[aa[i]-'a']++;
                cntb[bb[i]-'a']++;
                if(!set.contains(aa[i])) sba.append(aa[i]);
                if(!set.contains(bb[i])) sbb.append(bb[i]);
            }
            if(!sba.toString().equals(sbb.toString())){//세 번째 조건
                answer = "NO";
            }else{
                for(int j=0; j<26; j++){
                    if(cnta[j]!=cntb[j]){//첫 번째 조건
                        answer = "NO";
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
