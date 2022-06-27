package baek.june_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4963 {
    public static void main(String[] args) throws Exception {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        Queue<int[]> que = new LinkedList<>();
        String input;

        while(!(input = reader.readLine()).equals("0 0")){
            String[] wh = input.split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);
            String[][] map = new String[h][w];

            for(int row=0; row<h; row++){
                map[row] = reader.readLine().split(" ");
            }

            int cnt = 0;
            for(int row=0; row<h; row++){
                for(int col=0; col<w; col++){
                    if(map[row][col].equals("1")){
                        cnt++;
                        map[row][col] = "0";
                        que.add(new int[]{row, col});
                        while(!que.isEmpty()){
                            int[] next = que.poll();
                            for(int i=0; i<8; i++){
                                int nx = next[1]+dx[i];
                                int ny = next[0]+dy[i];
                                if(nx<0 || nx>=w || ny<0 || ny>=h || !map[ny][nx].equals("1")){
                                    continue;
                                }
                                map[ny][nx] = "0";
                                que.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
            writer.write(cnt+"\n");
        }
        writer.flush();
    }
}
