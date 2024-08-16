import java.util.*;

class Solution {
    
    List<List<Integer>> tree;
    int N;
    boolean[] isLeaf;
    boolean[] isOnOff;
    boolean[] visited;
    int result = 0;
    public int solution(int n, int[][] lighthouse) {
        N = n;
        
        tree = new ArrayList<>();
        
        isLeaf = new boolean[N + 1];
        visited = new boolean[N + 1];
        isOnOff = new boolean[N + 1];
        
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N - 1; i++){
            tree.get(lighthouse[i][0]).add(lighthouse[i][1]);
            tree.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        dfs(1, 0);
    
        return result;
    }
    
    public int dfs(int root, int before){
        visited[root] = true;
        
        if(tree.get(root).size() == 1 && tree.get(root).get(0) == before){
            // isLeaf[root] = true;
            // isOnOff[root] = false;
            return 1;
        }
        
        int compare = 0;
        for(int node : tree.get(root)){
            if(node != before){
                compare += dfs(node, root);
            }
        }
        
        // System.out.println(root + " " + compare);
        if(compare == 0){
            return 1;
        }
        
        result++;
        return 0;
    }
}