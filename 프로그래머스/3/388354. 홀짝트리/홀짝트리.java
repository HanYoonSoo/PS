import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> map;
    Set<Integer> visited;
    int[] result;
    public int[] solution(int[] nodes, int[][] edges) {
        map = new HashMap<>();
        
        for(int node : nodes){
            map.put(node, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        int[] answer = new int[2];
        
        visited = new HashSet<>();
        
        for(int node : map.keySet()){
            if(visited.contains(node))
                continue;
            
            result = new int[4];
            
            findComponent(node, -1);
            
            // System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
            
            if((result[2] == 1 && result[3] == 0) || 
                result[2] == 0 && result[3] == 1){
                answer[1]++;        
            } if((result[0] == 1 && result[1] == 0) || 
                result[0] == 0 && result[1] == 1){
                answer[0]++;
            }
        }
        
        return answer;
    }
    
    public void findComponent(int root, int parent){
        visited.add(root);
        
        int childCount = map.get(root).size();
        
        if(root % 2 == 1 && childCount % 2 == 1){
            result[0]++;
        } if(root % 2 == 0 && childCount % 2 == 0){
            result[1]++;
        } if(root % 2 == 1 && childCount % 2 == 0){
            result[2]++;
        } if(root % 2 == 0 && childCount % 2 == 1){
            result[3]++;
        }
        
        for(int child : map.get(root)){
            if(!visited.contains(child)){
                findComponent(child, root);
            }
        }
    }
}