import java.util.*;

class Solution {
    
    class Edge{
        int end;
        int w;
        
        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Edge>[] graph = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] r : road){
            int v1 = r[0];
            int v2 = r[1];
            int w = r[2];
            
            graph[v1].add(new Edge(v2, w));
            graph[v2].add(new Edge(v1, w));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Edge(1, 0));
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            
            if(dist[curr.end] < curr.w)
                continue;
            
            for(Edge edge : graph[curr.end]){
                if(dist[edge.end] > curr.w + edge.w){
                    dist[edge.end] = curr.w + edge.w;
                    pq.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
        
        for(int i = 2; i <= N; i++){
            if(dist[i] <= K)
                answer++;
        }
        

        return answer + 1;
    }
}