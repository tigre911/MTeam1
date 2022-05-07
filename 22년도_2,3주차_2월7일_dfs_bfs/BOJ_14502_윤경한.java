package baek.feb_14_extra;

import java.io.*;
import java.util.*;

public class BOJ_14502 {
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

        String[] NM = reader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        LinkedList<Position> vList = new LinkedList<>(); //바이러스 위치
        LinkedList<Position> wList = new LinkedList<>(); //벽 위치
        List<Position> zList = new ArrayList<>(); //빈칸 위치
        int zCount = 0;
        int zMax = 0;

        for(int a=0; a<N; a++){
            String[] row = reader.readLine().split(" ");

            for(int b=0; b<M; b++){
                int tmp = Integer.parseInt(row[b]);

                if(tmp==0){
                    zList.add(new Position(b,a));
                    zCount++;
                }else if(tmp==1){
                    wList.offer(new Position(b, a));
                }else{
                    vList.offer(new Position(b, a));
                }
            }
        }

        int zcTmp;
        for(int a=0; a<zList.size()-2; a++){
            for(int b=a+1; b<zList.size()-1; b++){
                for(int c=b+1; c<zList.size(); c++){
                    LinkedList<Position> wTmp = new LinkedList<>();
                    for(Position p:wList){
                        wTmp.offer(p);
                    }
                    wTmp.offer(zList.get(a));
                    wTmp.offer(zList.get(b));
                    wTmp.offer(zList.get(c));
                    zcTmp = zCount-3;
                    boolean[][] lab = new boolean[N][M];

                    for(Position p:wTmp){
                        lab[p.y][p.x] = true;
                    }
                    for(Position p:vList){
                        lab[p.y][p.x] = true;
                    }
                    LinkedList<Position> vTmp = new LinkedList<>();
                    for(Position tmp:vList){
                        vTmp.offer(tmp);
                    }

                    while(vTmp.size()>0){
                        Position tmp = vTmp.poll();
                        if(tmp.y-1>=0){ //위쪽 확인 및 증식
                            if(!lab[tmp.y-1][tmp.x]){
                                lab[tmp.y-1][tmp.x] = true;
                                zcTmp--;
                                vTmp.offer(new Position(tmp.x, tmp.y-1));
                            }
                        }
                        if(tmp.x-1>=0){ //왼쪽 확인 및 증식
                            if(!lab[tmp.y][tmp.x-1]){
                                lab[tmp.y][tmp.x-1] = true;
                                zcTmp--;
                                vTmp.offer(new Position(tmp.x-1, tmp.y));
                            }
                        }
                        if(tmp.x+1<M){ //오른쪽 확인 및 증식
                            if(!lab[tmp.y][tmp.x+1]){
                                lab[tmp.y][tmp.x+1] = true;
                                zcTmp--;
                                vTmp.offer(new Position(tmp.x+1, tmp.y));
                            }
                        }
                        if(tmp.y+1<N){ //아래쪽 확인 및 증식
                            if(!lab[tmp.y+1][tmp.x]){
                                lab[tmp.y+1][tmp.x] = true;
                                zcTmp--;
                                vTmp.offer(new Position(tmp.x, tmp.y+1));
                            }
                        }
                    }
                    if(zcTmp>zMax){
                        zMax = zcTmp;
                    }
                    
                }
            }
        }
        writer.write(zMax+"");
        writer.close();
    }
}
