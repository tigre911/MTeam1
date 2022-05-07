package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1388 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char arr[][] = new char[n][m];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
	            if (arr[i][j] == '-') {
	            	count++;
	                while (j < m && arr[i][j] == '-') {
	                    j++;
	                }
	            }
	        }
		}
		
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == '|') {
                    count++;
                    while (j < n && arr[j][i] == '|') {
                        j++;
                    }
                }
            }

        }
		String count2 = Integer.toString(count);
		bw.write(count2);
		bw.close();
		
		

	}

}
