import java.util.*;

class Solution {
    
    class Edge implements Comparable<Edge>{
        int end;
        int w;
        
        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }
    
    List<Edge>[] graph;
    int INF = 200 * 100000 + 1;;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            int v1 = fare[0];
            int v2 = fare[1];
            int w = fare[2];
            
            graph[v1].add(new Edge(v2, w));
            graph[v2].add(new Edge(v1, w));
        }
        
        int[] dist = new int[n + 1];
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        
        Arrays.fill(dist, INF);
        Arrays.fill(distA, INF);
        Arrays.fill(distB, INF);
        
        dist = dijkstra(s, dist);
        distA = dijkstra(a, distA);
        distB = dijkstra(b, distB);
        
        int minA = distA[s];
        int minB = distB[s];
        
        int result = minA + minB;
        
        for(int i = 1; i <= n; i++){
            result = Math.min(dist[i] + distA[i] + distB[i], result);
        }
        
        return result;
    }
    
    public int[] dijkstra(int node, int[] dist){
        dist[node] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(node, 0));
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            
            if(dist[curr.end] < curr.w)
                continue;
            
            for(Edge edge : graph[curr.end]){
                if(dist[edge.end] > dist[curr.end] + edge.w){
                    dist[edge.end] = dist[curr.end] + edge.w;
                    
                    pq.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
        
        return dist;
    }
    
}