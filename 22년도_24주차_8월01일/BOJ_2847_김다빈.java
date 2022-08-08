package study024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2847 {
	public static void main(String[] args) throws IOException{
		
		
		Scanner sc = new Scanner(System.in);
		int ans = 0; // 정답, 동준이가 점수를 내린 횟수
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt(); // 입력을 받음
		for(int i = n-2; i >= 0; i--) {
			// n = 4일 경우, 배열의 index는 0, 1, 2, 3이 존재함.
			// 2번과 3번, 1번과 2번, 0번과 1번을 비교하고자 n-2부터 시작하여 0번까지 반복
			if(arr[i] >= arr[i+1]) { // 낮은 레벨의 점수가 높은 레벨보다 크거나 같은 경우
				int diff = arr[i] - arr[i+1] + 1; //n번째 수가 n+1보다 1만큼 작게 하기 위한 차이
				ans += diff;
				arr[i] -= diff;
			}
		}
		System.out.println(ans);
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		//StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int n = Integer.parseInt(br.readLine());
//		int[] arr = new int[n];
//		
//		for(int i = 0; i<n; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		// 배열 거꾸로 뒤집기
//		int[] reverse = new int[n];
//		for(int i=arr.length-1, j=0; i>=0; i--,j++) {
//			reverse[j] = arr[i];
//		}
//		
//		
//		// int[n]이 가장 큰 수여야함 
//		// arr[n]-1,2,3.. 일수록 -1점일것
//		
//		
//		
//		int cnt = 0;
//		
//		for(int i=0; i<n; i++) {
//			if(reverse[i]<reverse[n-1]) {
//				if(reverse[i] <= reverse[i+1]) {
//					cnt++;
//					reverse[i+1] = reverse[i+1]-1;
//				} else {
//					continue;
//				}
//			}else {
//				if(reverse[n-1] <= reverse[n]) {
//					cnt++;
//					reverse[n] = reverse[n]-1;
//				}else {
//					continue;
//				}
//			}
//		}
		
		
		
//		for(int i=1; i<=n; i++) {
//			if(reverse[i]<reverse.length-1) {
//				if(reverse[i]<=reverse[i+1]) {
//					cnt++;
//					reverse[i+1] = reverse[i+1]-1;
//				}
//			}else {
//				if(reverse[n]<reverse[n-1]) {
//					cnt++;
//					reverse[n-1] = reverse[n-1]+1;
//				}
//			}
//			
//		}
		
//		System.out.println(cnt);
	}
}
