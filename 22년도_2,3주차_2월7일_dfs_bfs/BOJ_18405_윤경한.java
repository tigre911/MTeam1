package baek.feb_7_dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ_18405 {
    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }     
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[][] virusMap = new int[N+1][N+1]; //시험관을 나타낼 2차원 배열
        LinkedList<Position>[] positions = new LinkedList[K+1]; //각 번호별 바이러스들의 좌표
                                                                //ex) positions[2]는 2번 바이러스의 좌표들
        for(int i=0; i<positions.length; i++){
            positions[i] = new LinkedList<>();
        }
        
        for(int i=0; i<N; i++){ //바이러스 위치 입력(행)
            StringTokenizer rowInfo = new StringTokenizer(reader.readLine());
            for(int j=0; j<N; j++){ //바이러스 위치 입력(열)
                int virusNum = Integer.parseInt(rowInfo.nextToken());
                virusMap[i+1][j+1] = virusNum;
                positions[virusNum].offer(new Position(j+1, i+1));
                
            }
        }

        StringTokenizer targetInfo = new StringTokenizer(reader.readLine());
        int S = Integer.parseInt(targetInfo.nextToken());
        int X = Integer.parseInt(targetInfo.nextToken());
        int Y = Integer.parseInt(targetInfo.nextToken());

        for(int n=0; n<S; n++){ //바이러스 증식 과정을 S회 수행
            for(int i=1; i<positions.length; i++){ //바이러스 번호(=i)순으로 한 번씩 증식
                LinkedList<Position> positionsTmp = new LinkedList<>();
                while(positions[i].size()>0){
                    positionsTmp.offer(positions[i].poll());
                }

                for(Position tmp:positionsTmp){ //모든 i번 바이러스에 대해 증식 절차 수행
                    if(tmp.y-1>=1){ //위쪽 확인 및 증식
                        if(virusMap[tmp.y-1][tmp.x]==0){
                            virusMap[tmp.y-1][tmp.x] = i;
                            positions[i].offer(new Position(tmp.x, tmp.y-1));
                        }
                    }
                    if(tmp.x-1>=1){ //왼쪽 확인 및 증식
                        if(virusMap[tmp.y][tmp.x-1]==0){
                            virusMap[tmp.y][tmp.x-1] = i;
                            positions[i].offer(new Position(tmp.x-1, tmp.y));
                        }
                    }
                    if(tmp.x+1<=N){ //오른쪽 확인 및 증식
                        if(virusMap[tmp.y][tmp.x+1]==0){
                            virusMap[tmp.y][tmp.x+1] = i;
                            positions[i].offer(new Position(tmp.x+1, tmp.y));
                        }
                    }
                    if(tmp.y+1<=N){ //아래쪽 확인 및 증식
                        if(virusMap[tmp.y+1][tmp.x]==0){
                            virusMap[tmp.y+1][tmp.x] = i;
                            positions[i].offer(new Position(tmp.x, tmp.y+1));
                        }
                    }
                }
            }
        }
        writer.write(virusMap[X][Y]+"");
        writer.flush();

    }
}
