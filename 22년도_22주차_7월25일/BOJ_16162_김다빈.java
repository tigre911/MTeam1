package study023;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16162 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 참가자의 음
		int a = Integer.parseInt(st.nextToken());
		// 고음의 첫항
		int b = Integer.parseInt(st.nextToken());
		// 공차
		int c = Integer.parseInt(st.nextToken());
		
		// 참가자 음알리는 배열
		int[] arr = new int[a];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최고음
		int max = 0;
		// 구하고자 하는 음일 때만 (초기값 = 첫음)
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != b) {
				continue;
			}
			// 최고음 +1
			max++;
			b += c;	// 고음의 첫항에 + 공차값
		}
		
		// 객체에 max값 추가
		sb.append(max);
		sb.append("\n");
		// String으로 변환
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}
