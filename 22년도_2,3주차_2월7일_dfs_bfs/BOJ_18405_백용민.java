import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18405_백용민 {
     static int N, M;
     static int s, x, y;
     static int[][] arr;
     static int[] dx = {1, -1, 0, 0};
     static int[] dy = {0, 0, 1, -1};

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          StringTokenizer stt = new StringTokenizer(br.readLine(), " ");

          N = Integer.parseInt(stt.nextToken());
          M = Integer.parseInt(stt.nextToken());

          arr = new int[N][N];

          for (int i = 0; i < N; i++) {
               stt = new StringTokenizer(br.readLine(), " ");
               for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(stt.nextToken());
               }
          }

          stt = new StringTokenizer(br.readLine(), " ");
          s = Integer.parseInt(stt.nextToken());
          x = Integer.parseInt(stt.nextToken()) - 1;
          y = Integer.parseInt(stt.nextToken()) - 1;

          loop:
          for (int i = 0; i < s; i++) {
               for (int j = 0; j < M; j++) {
                    bfs((j + 1));

                    if (arr[x][y] != 0) {
                         break loop;
                    }
               }
          }

          bw.write(arr[x][y] + "\n");
          bw.flush();
          bw.close();
     }

     public static void bfs(int virus) {
          Queue<Pair> queue = new LinkedList<>();

          for (int i = 0; i < N; i++) {
               for (int j = 0; j < N; j++) {
                    if (arr[i][j] == virus) {
                         queue.add(new Pair(i, j));
                    }
               }
          }

          while (!queue.isEmpty()) {
               Pair qu = queue.poll();

               for (int k = 0; k < 4; k++) {
                    int nx = qu.x + dx[k];
                    int ny = qu.y + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if (arr[nx][ny] != 0) continue;

                    arr[nx][ny] = virus;
               }
          }
     }

     static class Pair {
          int x, y;

          public Pair(int x, int y) {
               this.x = x;
               this.y = y;
          }
     }
}
