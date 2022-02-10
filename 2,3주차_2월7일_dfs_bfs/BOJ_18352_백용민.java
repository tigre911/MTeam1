import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_18352_백용민 {
        /* 무한을 의미하는 값으로 10억을 설정 */
        public static final int INF = (int) 1e9;

        public static int n; // 노드의 개수(N)
        public static int m; // 간선의 개수(M)
        public static int di;
        public static int start; // 시작 노드 번호(Start)
        static PriorityQueue<QueueNode> pq;

        /* 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열 */
        public static ArrayList<ArrayList<QueueNode>> graph = new ArrayList<>();

        /* 최단 거리 테이블 만들기 */
        public static int[] d;


        public static void main(String[] args) throws IOException {

                input();


                /* 다익스트라 알고리즘을 수행 */
                dijkstra(start);
                System.out.println(Arrays.toString(d));
                for (int y = 0; y < d.length; y++) {
                        if (d[y] == INF) {
                                d[y] = 0;
                        }
                }
//                int[] result = Arrays.stream(d).filter(x -> x != INF).toArray();
                System.out.println(Arrays.toString(d));
                int o = 0;

//                System.out.println(Arrays.asList(result).indexOf(di));
                if (IntStream.range(0, d.length).
                        filter(i -> di == d[i]).
                        findFirst().orElse(-1) != -1) {
                        for (int k : d) {
                                if (k == di) {
                                        System.out.println(o);
                                }
                                o++;
                        }
                } else {
                        System.out.print(-1);

                }
        }

        private static void dijkstra(int start) {
                /* 우선순위 큐 선언 */
                pq = new PriorityQueue<>();

                /* 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입 */
                pq.offer(new QueueNode(start, 0));
                d[start] = 0;

                /* 큐가 비어있지않을 때까지 반복 */
                while(!pq.isEmpty()) {
                        /* 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기 */
                        QueueNode node = pq.poll();

                        int dist = node.getDistance(); // 현재 노드까지의 비용
                        int now = node.getIndex(); // 현재 노드 번호

                        /* 현재 노드가 이미 처리된 적이 있는 노드라면 무시 */
                        if (d[now] < dist) {
                                continue;
                        }

                        /* 현재 노드와 연결된 다른 인접한 노드들을 확인 */
                        for (int i = 0; i < graph.get(now).size(); i++) {
                                /* 현재의 최단거리 + 현재의 연결된 노드의 비용 */
                                int cost = d[now] + graph.get(now).get(i).getDistance();

                                /* 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 */
                                if (cost < d[graph.get(now).get(i).getIndex()]) {
                                        d[graph.get(now).get(i).getIndex()] = cost;
                                        pq.offer(new QueueNode(graph.get(now).get(i).getIndex(), cost));
                                }
                        }
                }
        }

        private static void input() throws IOException {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String s = bf.readLine(); //String
                StringTokenizer st = new StringTokenizer(s);
                n = Integer.parseInt(st.nextToken());  // 도시 수
                m = Integer.parseInt(st.nextToken());  // 간선 수
                di = Integer.parseInt(st.nextToken()); //목표 거리
                start = Integer.parseInt(st.nextToken()); // 시작도시

                d = new int[n+1];

                /* 그래프 초기화 */
                for (int i = 0; i <= n; i++) {
                        graph.add(new ArrayList<>());
                }


                for(int i = 0; i < m; i++) {
                        s = bf.readLine();
                        st = new StringTokenizer(s);
                        int startCity = Integer.parseInt(st.nextToken());
                        int endCity = Integer.parseInt(st.nextToken());
                        graph.get(startCity).add(new QueueNode(endCity, 1));
                }

                /* 최단 거리 테이블을 모두 무한으로 초기화 */
                Arrays.fill(d, INF);
        }
}

class QueueNode implements Comparable<QueueNode> {

        private final int index;
        private final int distance;

        public QueueNode(int index, int distance) {
                this.index = index;
                this.distance = distance;
        }

        public int getIndex() {
                return this.index;
        }

        public int getDistance() {
                return this.distance;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(QueueNode other) {
                if (this.distance < other.distance) {
                        return -1;
                }
                return 1;
        }
}