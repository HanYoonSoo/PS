import java.util.*;

class Solution {
    List<List<Edge>> graph;

    static class Edge implements Comparable<Edge>{
        int v;
        int dist;

        public Edge(int v, int dist){
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge e){
            return this.dist - e.dist;
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());    
        }

        for(int[] curr : edge){
            int start = curr[0];
            int end = curr[1];

            graph.get(start).add(new Edge(end, 1));
            graph.get(end).add(new Edge(start, 1));
        }

        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(1, 0));

        int max = 0;
        while(!pq.isEmpty()){
            Edge edgeCur = pq.poll();

            int curr = edgeCur.v;
            int distance = edgeCur.dist;

            max = Math.max(max, distance);

            if(!visited[curr]){
                visited[curr] = true;

                for(Edge e : graph.get(curr)){
                    if(!visited[e.v] && dist[e.v] > distance + e.dist){
                        dist[e.v] = distance + e.dist;
                        pq.add(new Edge(e.v, dist[e.v]));
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(max == dist[i]){
                answer++;
            }
        }
        return answer;
    }
}