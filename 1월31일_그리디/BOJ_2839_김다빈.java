package study003;

import java.util.Scanner;

public class BOJ_2839_김다빈 {
	public static void main(String[] args) {
		Scanner sc33 = new Scanner(System.in);
		
		//	1)	n입력받기
		int n = sc33.nextInt();
		int[] ar33 = new int[5000];			//	범위 3과 5000사이이므로 넉넉히 5000
		
		//	2)	z=5x+3y
		int x = 5;							//	5kg 설탕
		int y = 3;							//	3kg 설탕
		int cnt = 0;
		
		//	3)	배열에 해를 저장하는데 이때, i와j는 해로 사용되므로 배열의 증감은 cnt(count)로 사용한다.
		for(int i=0; i<=10000; i++) {	
			for(int j=0; j<=10000; j++) {
				if(((i*x)+(j*y)) == n) {	//	5i + 3j = n	일때
					ar33[cnt] = i+j;		//	i와 j의 값을 구하여 더해서 넣어준다. -> 그 방법중 최소값을 구해야 하므로 더해준다.
					cnt++;					//	cnt 증감
				}
			}
		}
		
		//	4)	배열의 값 중 최소값을 구한다.
		int min = 5000;						
		for(int i=0;i<cnt; i++) {			
			if(ar33[i] < min) {				//	배열[i]의 값이 min보다 작다면 min은 그 작은 값을 갖는다.
				min = ar33[i];				//	최소값 구하기
			}
		}
		
		
		if(min == 5000) {					//	만약 min의 값이 5000, 즉 초기값과 같다면 방법이 없는것이므로 -1출력
			min = -1;
		}
		
		System.out.println(min);
		
	}
}
