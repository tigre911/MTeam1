package baek.feb_7_dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ_1260 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NMV = reader.readLine().split(" ");
        int N = Integer.parseInt(NMV[0]);
        int M = Integer.parseInt(NMV[1]);
        int V = Integer.parseInt(NMV[2]);

        List<Integer>[] routes = new ArrayList[N+1];
        for(int i=0; i<routes.length; i++){
            routes[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            String[] tmp = reader.readLine().split(" ");
            int nodeOne = Integer.parseInt(tmp[0]);
            int nodeTwo = Integer.parseInt(tmp[1]);
            if(!routes[nodeOne].contains(nodeTwo)){
                routes[nodeOne].add(nodeTwo);
            }
            if(!routes[nodeTwo].contains(nodeOne)){
                routes[nodeTwo].add(nodeOne);
            }
        }

        ///////////////////////////// DFS ////////////////////////////////
        boolean[] dfsVisited = new boolean[N+1];
        dfsFunction(routes, dfsVisited, V, writer);
        writer.write("\n");


        ///////////////////////////// BFS ////////////////////////////////
        boolean[] bfsVisited = new boolean[N+1];
        LinkedList<Integer> bfsNodes = new LinkedList<>();
        bfsNodes.offer(V);
        bfsVisited[V] = true;

        while(!bfsNodes.isEmpty()){
            int n = bfsNodes.poll();
            writer.write(n+" ");

            PriorityQueue<Integer> each = new PriorityQueue<>();
            for(int tmp:routes[n]){
                each.offer(tmp);
            }
            while(!each.isEmpty()){
                int cn = each.poll();
                if(!bfsVisited[cn]){
                    bfsVisited[cn] = true;
                    bfsNodes.offer(cn);
                }
            }
        }
        writer.close();
    }
    static void dfsFunction(List<Integer>[] routes, boolean[] dfsVisited, int point, 
                            BufferedWriter writer) throws Exception{
        writer.write(point+" ");
        dfsVisited[point] = true;

        PriorityQueue<Integer> dfsNodes = new PriorityQueue<>();
        for(int route:routes[point]){
            dfsNodes.offer(route);
        }

        while(dfsNodes.size()>0){
            int node = dfsNodes.poll();
            if(!dfsVisited[node]){
                dfsFunction(routes, dfsVisited, node, writer);
            }
        }
    }
}
