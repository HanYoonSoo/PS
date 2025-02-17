import java.util.*;

class Solution {
    int INF = 100000;
    public int solution(int[][] info, int n, int m) {
        int N = info.length;
        
        int[][] dp = new int[N + 1][m];
        
        for(int i = 0; i <= N; i++){
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
 
        for(int i = 1; i <= N; i++){
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for(int j = 0; j < m; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                
                if(j - b >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - b]);
                }
            }
        }
        
        int min = INF;
        
        for(int i = 0; i < m; i++){
            min = Math.min(dp[N][i], min);
        }
        
        return min >= n ? -1 : min;
    }
}