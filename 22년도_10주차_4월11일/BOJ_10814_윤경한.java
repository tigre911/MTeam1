package baek.apr_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_10814 {
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }     
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        Member[] ms = new Member[N];
        
        for(int i=0; i<N; i++){
            String[] s = reader.readLine().split(" ");
            ms[i] = new Member(Integer.parseInt(s[0]), s[1]);
        }
        
        Comparator<Member> comp = (x, y)->{
            return x.age-y.age;
        };

        Arrays.sort(ms, comp);

        for(Member m:ms){
            writer.write(m.age+" "+m.name+"\n");
        }
        writer.flush();
    }
}
