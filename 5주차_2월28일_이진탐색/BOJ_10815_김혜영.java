import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//백준 10815번: 숫자 카드
public class BOJ_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		//배열 생성
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		tree t = new tree();
	    t.makeTree(arr); 			//배열 입력
	        
		int M = Integer.parseInt(br.readLine());
		
		//검색할 데이터 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			t.searchBtree(t.root, Integer.parseInt(st.nextToken()));
		}
	}
}

//오름차순 배열기준 이진검색트리
class tree {
	 Node root;
 
  static class Node {
      int data;
      Node left;
      Node right;

      public Node(int data) {
          this.data = data;
      }
  }//Node
  
  public void makeTree(int[] arr) {
	        root = makeTree(arr, 0, arr.length - 1); //return된 중간노드를 루트로 설정
	}
  
  public Node makeTree(int[] arr, int start, int end) {
  	
      if (start > end) return null;				//재귀호출 종료 설정

      int mid = (start + end) / 2;  				//중간지점 설정
      Node node = new Node(arr[mid]);
      node.left = makeTree(arr, start, mid - 1); 	//왼쪽부분 재귀호출
      node.right = makeTree(arr, mid + 1, end); 	//오른쪽부분 재귀호출
      return node;
  }

  public void searchBtree(Node n, int find) {
  	if(find < n.data) {			 
  		if(n.left==null) {
  			System.out.print("0"+" ");
  		} else {
  		searchBtree(n.left, find);
  		}
  	}else if(find > n.data) {
  		if(n.right==null) {
  			System.out.print("0"+" ");
  		} else {
  		searchBtree(n.right, find);
  		}  	
  	} else if (find == n.data){
  		System.out.print("1" + " ");
  	}
  }
}