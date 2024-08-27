import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int N;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        N = n;
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());    
        }
        
        for(int i = 0; i < N - 1; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < N - 1; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a).remove(graph.get(a).indexOf(b));
            graph.get(b).remove(graph.get(b).indexOf(a));
            
            boolean[] visited = new boolean[N + 1];
            int[] temp = new int[2];
            int idx = 0;
            
            for(int j = 1; j <= N; j++){
                if(!visited[j]){
                    temp[idx++] = dfs(j, visited);
                }
            }
            
            result = Math.min(result, Math.abs(temp[0] - temp[1]));
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return result;
    }
    
    public int dfs(int start, boolean[] visited){
        visited[start] = true;
        
        int result = 1;
        
        for(int node : graph.get(start)){
            if(!visited[node]){
                result += dfs(node, visited);
            }
        }
        
        return result;
    }
}