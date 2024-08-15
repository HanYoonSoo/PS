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
    
    Node[] tree;
    int N;
    int M;
    int answer;
    public int solution(int[] info, int[][] edges) {
    
        N = info.length;
        tree = new Node[N];
        
        for(int i = 0; i < N; i++){
            tree[i] = new Node(info[i]);
        }
        
        M = edges.length;
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            
            tree[a].child.add(b);
        }
        
        answer = 0;
        
        dfs(0, 0, 0, new ArrayList<>());
        
        return answer;
    }
    
    public void dfs(int root, int sheep, int wolf, List<Integer> path){        
        if(tree[root].kind == 0){
            sheep++;
        } else{
            wolf++;
        }
        
        // System.out.println(root + " " + sheep + " " + wolf);
        
        if(sheep == wolf){
            return;
        }
        
        if(sheep > wolf){
            answer = Math.max(answer, sheep);
        }
        
        List<Integer> newPath = new ArrayList<>();
        newPath.addAll(path);
        
        newPath.remove(Integer.valueOf(root));
        
        for(int child : tree[root].child){
            newPath.add(child);
        }
        
        for(int node : newPath){
            dfs(node, sheep, wolf, newPath);
        }
    }
}