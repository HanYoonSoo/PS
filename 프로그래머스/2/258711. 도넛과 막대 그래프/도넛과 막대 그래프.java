import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int maxVertex;
    boolean[] visited;
    boolean[] check;
    int[] inDegree;
    int startVertex;
    
    public void init(int[][] edges){
        maxVertex = 0;
        check = new boolean[1000000];
        
        for(int[] edge : edges){
            check[edge[0]] = true;
            check[edge[1]] = true;
            
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }
        
        graph = new ArrayList<>();
        visited = new boolean[maxVertex + 1];
        inDegree = new int[maxVertex + 1];
        
        for(int i = 0; i <= maxVertex; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
    }
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        init(edges);
        
        startVertex = findCreatedV();
        answer[0] = startVertex;
        
        int canFindGraph = graph.get(startVertex).size();
        
        for(int node : graph.get(startVertex)){
            inDegree[node]--;    
        }
        
        answer[2] = countBarGraphs();
        answer[3] = countEightGraphs();
        
        answer[1] = canFindGraph - answer[2] - answer[3];
        return answer;
    }
    
    public int findCreatedV(){
        int createdV = -1;
        
        for(int i = 1; i < graph.size(); i++){
            if(graph.get(i).size() >= 2 && inDegree[i] == 0){
                createdV = i;
                break;
            }
        }
        
        return createdV;
    }
    
    public int countBarGraphs(){
        int count = 0;
        for(int i = 1; i < graph.size(); i++){
            if(i == startVertex){
                continue;
            }
            
            if(check[i] && graph.get(i).size() == 0){
                count++;
                visited[i] = true;
            }
        }
        
        return count;
    }
    
    public int countEightGraphs(){
        int count = 0;
        for(int i = 1; i < graph.size(); i++){
            if(!visited[i]){
                if(graph.get(i).size() == 2 && inDegree[i] == 2){
                    count++;
                }
            }
        }
        
        return count;
    }
}