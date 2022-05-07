package baek.march_28_dfs_bfs;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] board) {
        int[] dy = {-1, 1, 0, 0}; //상하좌우 순서
        int[] dx = {0, 0, -1, 1};
        int N = board.length; //경주로의 가로 또는 세로 길이(정사각형)
        
        int[][][] cost = new int[N][N][4]; 
        //ex) 앞의 두 N은 각각 y좌표, x좌표이며 마지막 4는 해당
        //지점 도착시의 최소 비용(상하좌우에서 접근하는 경우들 모두 고려)
        
        for(int a=0; a<N; a++){
            for(int b=0; b<N; b++){
                for(int c=0; c<4; c++){
                    cost[a][b][c] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1});//[0:상][1:하][2:좌][3:우]
        q.add(new int[]{0, 0, 0, 3});
        //배열의 각 요소는 순서대로 y축, x축, 해당 지점까지의 최소비용, 다음에 움직일 방향
        
        while(!q.isEmpty()){
            int[] each = q.poll();
            
            for(int i=0; i<4; i++){
                int ny = each[0]+dy[i];
                int nx = each[1]+dx[i];
                int nc = each[2]+(each[3]==i ? 100 : 600);
                
                if(ny<0 || nx<0 || ny>=N || nx>=N || //이동 가능 범위를 벗어나거나
                   board[ny][nx]==1 || //다음 이동할 지점이 벽이거나
                   cost[ny][nx][i]<=nc){ //이동할 지점까지 계산한 최소값이 이미 들어간 값보다 크다면
                    //비용 갱신과 이동 절차는 수행하지 않음
                    continue;
                }
                cost[ny][nx][i] = nc;
                q.add(new int[]{ny, nx, nc, i});
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int tmp:cost[N-1][N-1]){
            answer = Math.min(answer, tmp);
        }
        
        return answer;
    }
}