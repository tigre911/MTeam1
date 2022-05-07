package baek.feb_7_dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1388 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = reader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[][] tiles = new String[N][M];
        for(int i=0; i<N; i++){
            tiles[i] = reader.readLine().split("");
        }

        int result = 0;
        String point = "X";

        for(int r=0; r<N; r++){   
            for(int c=0; c<M; c++){
                if(tiles[r][c].equals("-")){
                    if(tiles[r][c].equals(point)){
                        continue;
                    }else{
                        result++;
                        point = "-";
                    }
                }else if(tiles[r][c].equals("|")){
                    result++;
                    point = "|";
                    int tmp = r+1;
                    while(tmp<N && tiles[tmp][c].equals("|")){
                        tiles[tmp][c] = "X";
                        tmp++;
                    }
                }else{
                    point = "X";
                }
            }
            point = "X";
        }
        System.out.println(result);
    }
}
