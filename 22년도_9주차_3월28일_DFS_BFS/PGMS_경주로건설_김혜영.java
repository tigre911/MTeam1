import java.util.LinkedList;
import java.util.Queue;

public class PGMS_경주로건설 {
	int min = Integer.MAX_VALUE;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    int n;
    boolean[][] visited;
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n];
        bfs(board);
        return min;
    }
    
    public void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();	//큐 생성
        q.add(new Node(0, 0, 0, -1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.x == n - 1 && node.y == n - 1) {	//도착지점 도달 시
                min = Math.min(min, node.cost);			// 기존의 min과 새로구한 node.cost 중 작은 값을 저장
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny]==0) {
                    int newCost;
                    if(node.dir == -1 || node.dir == i) { //직진
                        newCost = node.cost + 100;		  //100
                    } else { 							  //코너
                        newCost = node.cost + 600;		  //100+500 =600
                    }
                   
                    //처음 방문하거나 이전에 방문했을 때의 cost보다 작거나 같은 비용이면
                    if(visited[nx][ny] == false || board[nx][ny] >= newCost) {
                        visited[nx][ny] = true;
                        board[nx][ny] = newCost; //값을 갱신해주고
                        q.add(new Node(nx, ny, newCost, i)); //해당 지점으로 이동
                    }
                } 
            }
        }
    }
    
    class Node{
        int x;
        int y;
        int cost;
        int dir;
        
        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
