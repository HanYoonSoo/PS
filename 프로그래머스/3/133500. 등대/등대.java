import java.util.*;

class Solution {
    int N;
    List<List<Integer>> tree;
    int result = 0;
    
    public int solution(int n, int[][] lighthouse) {
        N = n;
        
        tree = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int[] light : lighthouse){
            tree.get(light[0]).add(light[1]);
            tree.get(light[1]).add(light[0]);
        }
        
        dfs(1, 0);
        
        return result;
    }
    
    public int dfs(int root, int before){
        if(tree.get(root).size() == 1 && tree.get(root).get(0) == before){
            return 1;
        }
        
        int compare = 0;
        
        for(int node : tree.get(root)){
            if(node != before){
                compare += dfs(node, root);
            }
        }
        
        if(compare == 0){
            // System.out.println(root);
            return 1;
        }
        
        result++;
        return 0;
    }
}