import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int N;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            int start = road[0];
            int end = road[1];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        
        int[] dist = dijkstra(destination);
        
        int[] result = new int[sources.length];
        
        int idx = 0;
        for(int source : sources){
            result[idx++] = dist[source] == Integer.MAX_VALUE ? -1 : dist[source];
        }
        
        return result;
    }
    
    public int[] dijkstra(int destination){
        int[] dist = new int[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[destination] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        pq.add(new int[]{destination, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            int end = curr[0];
            int w = curr[1];
            
            if(w > dist[end]){
                continue;
            }
            
            for(int node : graph.get(end)){
                if(dist[node] > w + 1){
                    dist[node] = w + 1;
                    pq.add(new int[]{node, dist[node]});
                }
            }
        }
        
        return dist;
    }
}