package baek.apr_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(reader.readLine());
        String[] serials = new String[N];

        for(int i=0; i<N; i++){
            serials[i] = reader.readLine();
        }

        Comparator<String> comp = (A, B)->{
            // 1번
            int Alen = A.length(), Blen = B.length();
            int len = Alen-Blen;
            if(len!=0){
                return len;
            }

            // 2번
            int Asum = 0, Bsum = 0;
            for(int i=0; i<Alen; i++){
                char Achar = A.charAt(i), Bchar = B.charAt(i);
                Asum += Achar<='9' ? Achar-'0' : 0;
                Bsum += Bchar<='9' ? Bchar-'0' : 0;
            }
            int dif = Asum-Bsum;
            if(dif!=0){
                return dif;
            }

            // 3번
            int c, i=0;
            do{
                c = A.charAt(i)-B.charAt(i++);
            }while(c==0);

            return c;
        };

        Arrays.sort(serials, comp);

        for(String s:serials){
            writer.write(s+"\n");
        }
        writer.flush();
    }
}
