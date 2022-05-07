package Algorithm.BaekjoonOnlineJudge.BOJ_1431;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1431_정구현{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.next());
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()<o2.length()) return -1; //길이가 짧은 순
                else if(o1.length()>o2.length()) return 1;
                else { //길이가 같다면
                    int sum1 = 0;
                    int sum2 = 0;
                    for(int i=0;i<o1.length();i++) {
                        if(o1.charAt(i)>='0' && o1.charAt(i)<='9')sum1+=(o1.charAt(i)-'0');
                        if(o2.charAt(i)>='0' && o2.charAt(i)<='9')sum2+=(o2.charAt(i)-'0');
                    }
                    if(sum1==sum2)return o1.compareTo(o2);
                    else {
                        return Integer.compare(sum1, sum2);
                    }
                }
            }
        });
        for(String i : arr)System.out.println(i);
    }
}
