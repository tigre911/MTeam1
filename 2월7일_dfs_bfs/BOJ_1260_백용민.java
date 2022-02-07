import java.io.*;
import java.util.*;

class GraphList {
    private ArrayList<ArrayList<Integer>> LG;

    public GraphList() {
        setLG(new ArrayList<ArrayList<Integer>>());
    }

    public ArrayList<ArrayList<Integer>> getLG() {
        return LG;
    }

    public void setLG(ArrayList<ArrayList<Integer>> LG) {
        this.LG = LG;
    }

    public void addVertex(int x) {
        getLG().add(new ArrayList<Integer>(x));
    }

    public void addGraphList(int x, int y) {
        getLG().get(x).add(y);
        getLG().get(y).add(x);
    }

    public void printGraphList() {
        for (int i = 0; i < getLG().size(); i++) {
            for (int j = 0; j < getLG().get(i).size(); j++) {
                System.out.print(" " + getLG().get(i).get(j));
            }
            System.out.println();
        }

    }
}

public class BOJ_1260_백용민 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        GraphList GL = new GraphList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt;

        stt = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[3];
        int[] edge = new int[2];
        int k = 0;

        //입력 첫줄
        while (stt.hasMoreTokens()) {
            arr[k++] = Integer.parseInt(stt.nextToken());
        }

        //노드 생성
        for (int i = 1; i <= arr[0] + 1; i++) {
            GL.addVertex(i);
        }

        //간선 수만큼 반복해서 두 수 사이의 연결관계 설정
        for (int i = 0; i < arr[1]; i++) {
            stt = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (stt.hasMoreTokens()) {
                edge[j++] = Integer.parseInt(stt.nextToken());
            }
            GL.addGraphList(edge[0], edge[1]);
        }//for


        GL.printGraphList();
        int[][] newGraph = new int[arr[0] + 1][arr[1]];
        for(int i=0; i<GL.getLG().size(); i++) {
            for(int j=0; j<GL.getLG().get(i).size(); j++) {
                newGraph[i][j] = GL.getLG().get(i).get(j);
            }
            Arrays.sort(newGraph[i]);
            System.out.println();
        }

        System.out.println(Arrays.deepToString(newGraph));

        visited = new boolean[arr[0] + 1];
        Arrays.fill(visited, false);
//        System.out.println(Arrays.toString(visited));
        int start = arr[2];
        dfs(start, newGraph);

        System.out.println();

        visited = new boolean[arr[0] + 1];
        Arrays.fill(visited, false);
        bfs(start, newGraph);
    }//main

    public static void dfs(int v, int[][] newGraph) {
        visited[v] = true;
        if(v != 0)
            System.out.print(v + " ");

        for (int i : newGraph[v]) {
            if (visited[i] == false) { //방문 상태가 false인 노드들에서만 dfs를 다시 실행
                dfs(i, newGraph);
            }
        }
    }

    public static void bfs(int v, int[][] newGraph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        //현재 노드를 방문 처리
        visited[v] = true;

        //큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            //큐에서 요소 하나를 뽑아 출력
            v = queue.poll();
            if(v != 0)
                System.out.print(v + " ");

            //인접한 노드 중 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i : newGraph[v]) {
                if(visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}

