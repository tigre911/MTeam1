package study015;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 블루레이에 들어가는 강의 수
		int m = sc.nextInt();	// 블루레이 수
		int a[] = new int[n];	// 강의 시간 배열
		int left = 0;			// 이분탐색-오른쪽
		int right = 0;			// 이분탐색-왼쪽
		
		// 강의 수만큼 강의 시간 입력받기
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			right += a[i];
			left = left < a[i] ? a[i] : left;	// left < a[i]가 true이면 a[i]=left;
		}	// right=45, left=9
		
		
		// mid보다 작은 갯수 구하기
		while (left <= right) {					// left <= right까지 반복
			int mid = (left + right) / 2;		// 중간 값
			int sum = 0;	// 다 더한 값
			int cnt = 0;	// 카운트
			// mid = 27
			System.out.println("right = "+right);
			System.out.println("left = "+left);
			System.out.println("mid = "+mid);
			
			for (int i = 0; i < n; i++) {
				System.out.println(sum+a[i]);
				if (sum + a[i] > mid) {			// 더한 값이 > 중간값 보다 클 때
					sum = 0;					// sum 초기화 및 카운트+1
					cnt++;
				}
				sum += a[i];					// 아니면 sum에 a[i]값 더하기
			}
			System.out.println("cnt: "+cnt);
			// sum이 0이 아닐 때 카운트
			
			if (sum != 0)cnt++;	
			System.out.println("cnt2: "+cnt);
			System.out.println(" ");
			
			// 카운트값이 블루레이보다 작거나 같을 때까지 right = 중간값 -1
			if (cnt <= m)right = mid - 1;
			
			// 크다면 left = 중간값 +1
			else left = mid + 1;
		}
		// left 출력
		System.out.println(left);
	}
}
