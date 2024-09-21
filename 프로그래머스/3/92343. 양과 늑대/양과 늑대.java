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
        
        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            
            tree[parent].child.add(child);
        }
        
        dfs(0, 0, 0, new ArrayList<>());
        
        return result;
    }
    
    public void dfs(int root, int sheep, int wolf, List<Integer> path){
        if(tree[root].kind == 0){
            sheep++;
        } else{
            wolf++;
        }
        
        if(sheep == wolf){
            return;
        }
        
        if(sheep > wolf){
            result = Math.max(sheep, result);
        }
        
        List<Integer> nextList = new ArrayList<>();
        
        nextList.addAll(path);
        
        nextList.remove(Integer.valueOf(root));
        
        for(int child : tree[root].child){
            nextList.add(child);
        }
        
        for(int nextNode : nextList){
            dfs(nextNode, sheep, wolf, nextList);
        }
    }
}