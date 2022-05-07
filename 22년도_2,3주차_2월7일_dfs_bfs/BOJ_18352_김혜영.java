import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Graphs{
	class Node{
		boolean visited;
		int data;
		LinkedList<Node> singleEdge;
		
		Node(int data){
			this.data = data;
			this.visited = false;
			singleEdge = new LinkedList<Node>();
		}
	}
		
		//노드값 입력
		Node[] nodes;
		
		Graphs(int size){
			nodes = new Node[size+1];
			for(int i=0; i<=size; i++) {
				nodes[i] = new Node(i);
			}
		}

	//단방향 도로 추가(LinkedList)
	void addSingleEdge(int idx1, int idx2){
		Node a = nodes[idx1];
		Node b = nodes[idx2];
		if(! a.singleEdge.contains(b)) { //a에 b로 가는 도로가 없다면
			a.singleEdge.add(b);		 //추가
		}
	}
	
	void bfs(int start, ArrayList<Integer> arr, int K){
		Node root = nodes[start];
		Queue<Node> q = new LinkedList<>(); //큐 생성
		q.offer(root);
		root.visited = true;
		int cnt=1;
		
		while(!q.isEmpty()){ 	//큐가 빌때까지
			Node r = q.poll(); 	//디큐
			
			
			for(Node n : r.singleEdge){ //노드r의 인접노드n에 대하여
				if(n.visited == false){ //방문하지 않았다면
					n.visited = true;
					q.offer(n); 		//인큐
					if(cnt==K) {
						arr.add(n.data); 
						arr.sort(Comparator.naturalOrder());
						}
					}
				}
			cnt++;
		}
	}
}
			

public class BOJ_18352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		int K = Integer.parseInt(st.nextToken()); //최단거리
		int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호

		Graphs g = new Graphs(N); //도로그래프 생성
		
		//단방향 도로 배열
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			g.addSingleEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		if(2<=N&&N<=300000 && 1<=M&&M<=1000000 && 1<=K&&K<=300000 && 1<=X&&X<=N){
		ArrayList<Integer> arr = new ArrayList<>();
		g.bfs(X,arr,K);
		
		//최단 거리가 K인 도시가 존재하지 않으면 -1 출력
		if(arr.isEmpty()) {
			System.out.print(-1);
		}
		//최단 거리가 K인 도시 출력
		for (int i = 0; i < arr.size(); i++) {
			   System.out.println(arr.get(i)); 
		}	
		}
	}
}
