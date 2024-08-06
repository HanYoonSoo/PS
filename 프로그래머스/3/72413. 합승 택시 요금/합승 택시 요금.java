import java.util.*;

class Solution {
    
    int INF = 200 * 100000 + 1;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        
        int m = fares.length;
        
        for(int i = 0; i < m; i++){
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int c = fares[i][2];
            
            graph[v1][v2] = c;
            graph[v2][v1] = c;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = graph[s][a] + graph[s][b];
        
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        
        
        return answer;
    }
}