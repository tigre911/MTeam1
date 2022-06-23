package Beakjoon;

import java.util.Arrays;
import java.util.Scanner;

// 한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
// 두 단어의 첫 글자와 마지막 글자는 서로 동일해야 한다.
// 각 단어에서 모음(a, e, i, o, u)을 제거한 문자열은 동일해야 한다.

public class BOJ_25178_신수진{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        String str1 = sc.next();
        String str2 = sc.next();

        String answer = "NO";

        // 1. 한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
        char[] char1 = str1.toCharArray();
        Arrays.sort(char1);
        String sortedStr1 = new String(char1);

        char[] char2 = str2.toCharArray();
        Arrays.sort(char2);
        String sortedStr2 = new String(char2);

        //모든 글자 같아야 함
        if(sortedStr1.equals(sortedStr2)){
            // 2. 두 단어의 첫 글자와 마지막 글자는 서로 동일해야 한다.
            if(str1.charAt(0) == str2.charAt(0) && str1.charAt(len-1) == str2.charAt(len-1)){
                // 3. 각 단어에서 모음(a, e, i, o, u)을 제거한 문자열은 동일해야 한다.
                String[] vowel = {"a", "e", "i", "o", "u"};

                for(int i=0; i<vowel.length; i++){
                    str1 = str1.replaceAll(vowel[i], "");
                    str2 = str2.replaceAll(vowel[i], "");
                }

                if(str1.equals(str2)){
                    answer = "YES";
                } 
            }
        }
        System.out.println(answer);
    }
}