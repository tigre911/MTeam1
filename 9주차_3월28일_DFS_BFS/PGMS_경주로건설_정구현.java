package Algorithm.PGMS.PGMS_경주로건설;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
시작점인 [0, 0]부터 [N - 1, N - 1]까지 경주로를 건설해 최솟값을 구하는 문제다.
단, 경사로를 건설하는데 코너는 500원이 추가적으로 비용이 들기 때문에
이전과 같은 방향으로 가지않는다면 직선(100)+코너(500)로
구성되는 길이 생기기때문에 600원의 비용이 들게 된다.




단순 2차원 배열을 통해 저장된 최소값보다 클 경우
방문하지 않도록 진행하면 안되는데,
만약 진행된 방향과 다르게 진행될 경우
값이 역전되는 경우가 발생하기 때문에
방향까지 함께 저장하는 3차원의 최소값으로 저장해야한다.
*/
public class PGMS_경주로건설_정구현 {
    public int solution(int[][] board) {
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
        int N = board.length;

        int[][][] cost = new int[N][N][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1});
        queue.add(new int[]{0, 0, 0, 3});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
                int c = cur[2] + (cur[3] == k ? 100 : 600);

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 1 || cost[ny][nx][k] <= c) continue;
                cost[ny][nx][k] = c;
                queue.add(new int[]{ny, nx, c, k});
            }
        }

        return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
    }
}