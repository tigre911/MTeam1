package study005;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_18352_김다빈 {


	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();			//	도시의 수	
		int m = sc.nextInt();			//	도로의 수
		int k = sc.nextInt();			//	최단 거리
		int x = sc.nextInt();			//	시작 도시 번호
	
		ArrayList<Integer>[] db = new ArrayList[n+1];		//	배열이 0부터 시작하니까, 도시의 수+1 크기의 배열 생성
		
		for(int i=0; i<db.length; i++) {
			db[i] = new ArrayList<Integer>();	// 배열[0] = 새로운 배열 값을 넣어준다. db[i]=db.length길이로 1~몇번째 길까지?
		}
		
		for(int i=0; i<m; i++) {
			db[sc.nextInt()].add(sc.nextInt());	//	db에 스캐너 값에 새 스캐너값을 넣어준다.
												//	즉, db[0]값을 입력받고 = 입력받은값을 추가 	이 작업을 도로 수만큼 하므로써 도로가 어디서 어디로가는지 
												//	1		-> 2
		}
		
		
		//	bfs시작
		Queue<Integer> q = new LinkedList<>();	
		//	Queue : 먼저 들어온 것부터 처리
		//	LinkedList<Integer> : LinkedList<Integer> 자료형을 가진 객체를 큐에 담는다.
		q.add(x);								//	q에 x값을 넣어준다. q=처음시작하는 수
		
		int[] check = new int[n+1];				//	check배열은  [1]~[도시의 수까지] 
		while(!q.isEmpty()) {					//	q의 값이 존재하지 않을 때 계속 반복
			int temp = q.poll();				//	temp = q.poll(); => temp로 q값(null) 빼내기
			
			for(int i=0; i<db[temp].size(); i++) {			//	경로(배열 db[])의 크기까지 i++
				check[db[temp].get(i)] = check[temp]+1;		//	체크배열 경로배열([db[].get(i)]) = check[null]+1;
				q.add(db[temp].get(i));						//	경로배열(db[].get[i])의 값을 q의 마지막에 추가
			}
		}		
		
		boolean ok = false;									//	ok란 논리형 변수 초기값 = false; -1때문에 만듦
		for(int i=1; i<check.length; i++) {					//	반복문 체크배열길이까지
			if(check[i]==k && i !=x) {						//	만약 체크배열[1]==최단거리와 같고 1이 도시시작번호가 아니면
				ok=true;									//	진실
				System.out.println(i);						//	i출력
			}
		}
		if(!ok) {											//	아니라면
			System.out.println(-1);							//	-1 출력
		}
	
	
	}
}
