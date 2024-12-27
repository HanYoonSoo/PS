import java.util.*;

class Solution {
    
    
    class Node{
        int kind;
        List<Integer> child;
        
        public Node(int kind){
            this.kind = kind;
            child = new ArrayList<>();
        }
    }
    
    int N;
    Node[] tree;
    int result = 0;
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        
        tree = new Node[N];
        
        for(int i = 0; i < N; i++){
            tree[i] = new Node(info[i]);
        }
        
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            tree[a].child.add(b);
        }
        
        dfs(0, 0, 0, new ArrayList<>());
        
        return result;
    }
    
    public void dfs(int sheep, int wolf, int node, List<Integer> path){
        if(tree[node].kind == 0){
            sheep++;
        } else{
            wolf++;
        }
        
        if(sheep == wolf){
            return;
        }
        
        result = Math.max(sheep, result);
        
        List<Integer> newPath = new ArrayList<>(path);
        newPath.remove((Integer)node);
        
        for(int child : tree[node].child){
            newPath.add(child);
        }
        
        for(int child : newPath){
            dfs(sheep, wolf, child, newPath);
        }
    }
}