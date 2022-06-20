package study018;


import java.util.*;


public class BOJ_1931 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 배열 선언하기 n*2 크기
		int[][] arr = new int[n][2];
		
		// 배열 입력하기
		// [i][0]은 시작시간, [i][1]은 종료시간
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		/*
			Compare, Comparator 모두 Interface
			compare(T o1, T o2)
			
		*/
		
		// 0번째 열 오름차순 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] x, int[] y) {
				return x[0]-y[0];
			}
		});
		// 1번째 열 오름차순 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] x, int[] y) {
				return x[1]-y[1];
			}
		});
		
		
		int cnt = 0;
		int end = 0;
		
		// 시작 시간이 end를 넘거나 같으면 cnt
		for(int i=0; i<n; i++) {
			if(arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
	}
}
