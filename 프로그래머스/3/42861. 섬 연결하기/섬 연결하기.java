import java.util.*;

class Solution {
    class Edge implements Comparable<Edge>{
        int end;
        int weight;
        
        public Edge(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }    
    }
    
    public int solution(int n, int[][] costs) {
        List<List<Edge>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        int M = costs.length;
        
        for(int i = 0; i < M; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int w = costs[i][2];
            
            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        visited[0] = true;
        
        for(Edge edge : graph.get(0)){
            pq.add(edge);
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
        
            if(visited[curr.end])
                continue;
            
            visited[curr.end] = true;
            
            answer += curr.weight;
            
            for(Edge e : graph.get(curr.end)){
                pq.add(new Edge(e.end, e.weight));
            }
        }
        
        return answer;
        
    }
}