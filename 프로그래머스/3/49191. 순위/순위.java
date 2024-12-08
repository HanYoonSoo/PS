import java.util.*;

/**
* 모든 정점을 다 접근해야 함
* 1 > 2, 2 > 3 ==> 1 > 3
* 1 < 2, 2 < 3 ==> 1 < 3
*
* 공통된 값은 고정으로 두고 나머지 노드 비교해야 함
* 
* i k
* k j
*
* 1 1, 1 2, 1 3, 1 4, 1 5 에서 k가 5라고 가정하면
* 5 1, 5 2, 5 3, 5 4, 5 5  위 아래 비교
*
* graph[i][k] == graph[k][j] --> i > j 
*/
class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        
        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            
            graph[a][b] = 1;
            graph[b][a] = -1;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if(graph[i][k] == -1 && graph[k][j] == -1){
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        int result = 0;
        
        for(int i = 1; i <= n; i++){
            
            int count = 0;
            
            for(int j = 1; j <= n; j++){
                if(i != j && graph[i][j] != 0){
                    count++;
                }    
            }
            
            if(count == n - 1){
                result++;
            }
        }
        
        return result;
    }
}
