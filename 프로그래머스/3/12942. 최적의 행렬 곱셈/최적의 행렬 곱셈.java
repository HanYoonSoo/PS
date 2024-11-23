class Solution {
    public int solution(int[][] matrix_sizes) {
        int N = matrix_sizes.length;
        
        int[][] dp = new int[201][201];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - i; j++){
                int a = j;
                int b = j + i;
                
                if(a == b)
                    dp[a][b] = 0;
                else{
                    dp[a][b] = Integer.MAX_VALUE;
                    
                    for(int k = a; k < b; k++){
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k + 1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }
            }
        }
        
        return dp[0][N - 1];
    }
}