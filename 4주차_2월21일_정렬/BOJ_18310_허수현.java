package week6;

import java.io.*;
import java.util.*;

public class BOJ_18310 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    int N = Integer.parseInt(br.readLine());
	    int []homes = new int[N];
	    int i=0;

	    StringTokenizer st = new StringTokenizer(br.readLine());

	    for ( i = 0; i < N; i++) {
	    	homes[i] = Integer.parseInt(st.nextToken());
        }

	    Arrays.sort(homes);

	    bw.write(Integer.toString(homes[N/2-1]));
	    bw.flush();
	    bw.close();

	}

}
