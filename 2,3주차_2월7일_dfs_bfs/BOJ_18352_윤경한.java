package baek.feb_7_dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ_18352 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NMKX = reader.readLine().split(" ");
        int N = Integer.parseInt(NMKX[0]); //도시 갯수
        int M = Integer.parseInt(NMKX[1]); //도로의 갯수(단방향)
        int K = Integer.parseInt(NMKX[2]); //최단 거리
        int X = Integer.parseInt(NMKX[3]); //출발 도시

        int[] shorts = new int[N+1]; //X에서 각 도시까지의 최단거리들 

        List<Integer>[] rList = new ArrayList[N+1]; //각 도시에서 갈 수 있는 도시를 저장
        for(int i=0; i<rList.length; i++){          //ex)rList[x]에는 x번 도시에서 갈 수 
            rList[i] = new ArrayList<>();           //있는 도시들의 번호가 저장됨
        }
        for(int i=0; i<M; i++){
            String[] tmp = reader.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            rList[from].add(to);
        }

        boolean[] visited = new boolean[N+1]; //각 도시의 방문 여부 저장
        int count = 0; //X로부터 이동한 거리를 저장
        Queue<Integer> moving = new LinkedList<>(); //X로부터 count만큼 이동한 지점의 도시들
        Queue<Integer> points = new LinkedList<>(); //작업을 쉽게 하기 위한 임시 큐
        moving.add(X);
        visited[X] = true;

        while(!moving.isEmpty()){
            while(moving.size()>0){
                points.add(moving.poll());
            }
            count++;
            for(int tmp:points){
                for(int next:rList[tmp]){
                    if(visited[next]==false){ //다음 목표 도시를 방문한 적이 없다면
                        visited[next] = true; //방문했다는 표시를 남김
                        shorts[next] = count; //문제 조건 하에서는 최초 방문시의 이동 횟수가 곧 최단거리
                        moving.add(next);
                    }
                }
            }
            points.clear();
        }
        boolean kExists = false;
        for(int i=0; i<shorts.length; i++){
            if(shorts[i]==K){
                writer.write(i+"\n");
                kExists = true;
            }
        }
        if(kExists==false){
            writer.write("-1");
        }
        writer.close();
    }
    
}
