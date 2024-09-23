import java.util.*;

class Solution {
    int[] parent;
    int N;
    public int solution(int n, int[][] computers) {
        
        N = n;
        parent = new int[N];
        
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i != j){
                    if(computers[i][j] == 1){
                        union(i, j);
                    }
                }
            }    
        }
        
        boolean[] visited = new boolean[200];
        
        int count = 0;
        for(int i = 0; i < N; i++){
            if(!visited[find_parent(parent[i])]){
                visited[find_parent(parent[i])] = true;
                count++;
            }
        }
        
        return count;
    }
    
    public int find_parent(int a){
        if(parent[a] == a){
            return a;
        }
        
        parent[a] = find_parent(parent[a]);
        
        return parent[a];
    }
    
    public void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);
        
        if(a <= b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }
}