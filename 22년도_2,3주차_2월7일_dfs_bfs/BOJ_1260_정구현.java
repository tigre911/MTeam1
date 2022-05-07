package Algorithm.BaekjoonOnlineJudge.BOJ_1260;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    public static int N;
    public static LinkedList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //노드 리스트  객체생성
        nodeList = new LinkedList[N+1];

        //인접 리스트 생성
        for (int i = 0; i <= N; i++) {
            nodeList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            //간선이 연결하는 두 정점의 번호 받아오기
            st = new StringTokenizer(br.readLine());

        //두 정점 초기화
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        nodeList[node1].add(node2);
        nodeList[node2].add(node1);

        Collections.sort(nodeList[node1]);
        Collections.sort(nodeList[node2]);
    }



        //String builder 객체 생성(문자열 붙일때 사용)
        StringBuilder dfsResult = new StringBuilder();
        StringBuilder bfsResult = new StringBuilder();

        //노드 방문 여부 확인
        boolean[] dfsVisited = new boolean[N +1];
        boolean[] bfsVisited = new boolean[N +1];

        dfs(V, dfsVisited, dfsResult);
        bfs(V, bfsVisited, bfsResult);



        bw.write(dfsResult + "\n" + bfsResult);
        bw.flush();
        bw.close();
        br.close();

    }

    //깊이 우선 탐색(DFS)
    public static void dfs(int node, boolean[] visited, StringBuilder sb) {
        //방문 여부 검사
        if(visited[node]) return;

        //미방문 노드일 시 true
        visited[node] = true;

        // 방문한 노드 추가
        sb.append(node + " ");

        //인접 노드 재귀 호출
        for (int nextNode : nodeList[node]) {
            dfs(nextNode, visited, sb);
        }
    }


    public static void bfs(int node, boolean[] visited, StringBuilder sb) {
        //노드를 담을 큐 생성
        Queue<Integer> queue = new LinkedList<Integer>();

        //노드를 큐에 추가
        queue.offer(node);

        //큐에 있는 노드를 탐색
        while (!queue.isEmpty()) {
            //큐에서 노드 추출
            node = queue.poll();

            //해당 노드 방문 여부 검사
            if (visited[node]) continue;

            //노드 방문 설정
            visited[node] = true;

            //방문한 노드 출력 추가
            sb.append(node + " ");

            //인접 노드 큐에 추가
            for (int nextNode : nodeList[node]) {
                queue.add(nextNode);
            }
        }


    }

}
