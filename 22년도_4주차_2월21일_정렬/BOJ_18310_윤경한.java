package baek.feb_21_sort;

import java.io.*;
import java.util.*;

public class BOJ_18310 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        String[] s = reader.readLine().split(" ");
        
        int[] positions = Arrays.stream(s).mapToInt(x->Integer.parseInt(x)).sorted().toArray();
        
        System.out.println(positions[(N-1)/2]);
    }
}
