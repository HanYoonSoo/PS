class Solution {
    public int minPathSum(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int[][] dp = new int[N][M];

        dp[0][0] = grid[0][0];

        for(int i = 1; i < M; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[N - 1][M - 1];
    }
}
