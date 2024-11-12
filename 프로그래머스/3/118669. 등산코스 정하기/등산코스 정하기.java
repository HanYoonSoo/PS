import java.util.*;

class Solution {
    
    class Edge{
        int end;
        int w;
        
        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }
    }
    
    int[] parent;
    boolean[] isGates;
    boolean[] isSummits;
    List<Edge>[] tree;
    int N;
    int summit = -1;
    int curSummit = 0;
    int result = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        
        parent = new int[N + 1];
        isGates = new boolean[N + 1];
        isSummits = new boolean[N + 1];
        visited = new boolean[N + 1];
        
        tree = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
            parent[i] = i;
            tree[i] = new ArrayList<>();
        }
        
        for(int g : gates){
            isGates[g] = true;
        }
        
        for(int s : summits){
            isSummits[s] = true;
        }
        
        Arrays.sort(paths, (o1, o2) -> o1[2] - o2[2]);
        
        for(int[] edge : paths){
            if(find_parent(edge[0]) != find_parent(edge[1])){
                union(edge[0], edge[1]);
                tree[edge[0]].add(new Edge(edge[1], edge[2]));
                tree[edge[1]].add(new Edge(edge[0], edge[2]));
            }
        }
        
        Arrays.sort(summits);
        
        for(int summit : summits){
            curSummit = summit;
            dfs(summit, -1);
            visited = new boolean[N + 1];
        }
        
        return new int[]{summit, result};
    }
    
    public void dfs(int root, int intensity){
        if(result < intensity)
            return;
        
        visited[root] = true;
        
        if(isGates[root]){
            if(result > intensity){
                result = intensity;
                summit = curSummit;
            }
            return;
        }
        
        for(Edge edge : tree[root]){
            if(!visited[edge.end] && !isSummits[edge.end]){
                dfs(edge.end, Math.max(intensity, edge.w));
            }
        }
        
    }
    
    public int find_parent(int p){
        if(parent[p] == p)
            return p;
        
        parent[p] = find_parent(parent[p]);
        
        return parent[p];
    }
    
    public void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);
        
        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }
}