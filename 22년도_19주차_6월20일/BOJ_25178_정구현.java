package Algorithm.BaekjoonOnlineJudge.BOJ_25178;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25178_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//문자열의 길이

        st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken(); //첫번째 단어

        st = new StringTokenizer(br.readLine());
        String str2 = st.nextToken(); //두번째 단어

        String[] vowels = {"a", "e", "i", "o", "u"};
        String result = "";

        char[] char1 = str1.toCharArray();
        Arrays.sort(char1);
        String sortedStr1 = new String(char1);

        char[] char2 = str2.toCharArray();
        Arrays.sort(char2);
        String sortedStr2 = new String(char2);

        //모든 글자 같아야 함
        if(sortedStr1.equals(sortedStr2)){
            //첫글자와 마지막글자 같아야함
            if((str1.charAt(0) == str2.charAt(0)) && (str1.charAt(N-1) == str2.charAt(N-1))){
                //모음을 제거한 문자열은 같아야함
                for(int i = 0; i<vowels.length; i++){
                   str1 = str1.replaceAll(vowels[i], "");
                   str2= str2.replaceAll(vowels[i], "");
                }
                if(str1.equals(str2)){
                    result = "YES";
                }else {
                    result = "NO";
                }
            }else {
                result = "NO";
            }
        }
        else{
            result = "NO";
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
