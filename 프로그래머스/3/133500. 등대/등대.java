import java.util.*;

class Solution {
    
    List<Integer>[] tree;
    int N;
    int result = 0;
    
    public int solution(int n, int[][] lighthouse) {
        N = n;
        tree = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] light : lighthouse){
            int a = light[0];
            int b = light[1];
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        dfs(1, -1);
        
        return result;
    }
    
    public int dfs(int root, int parent){
        if(tree[root].size() == 1 && tree[root].get(0) == parent){
            return 1;
        }
        
        int compute = 0;
        for(int node : tree[root]){
            if(node != parent){
                compute += dfs(node, root);
            }
        }
        
        if(compute == 0){
            return 1;
        }
        
        result++;
        return 0;
    }
    
}