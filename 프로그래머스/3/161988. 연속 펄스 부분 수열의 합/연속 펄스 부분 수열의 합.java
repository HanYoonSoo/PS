class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[][] dp = new long[sequence.length][2];
        
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        long max = Math.max(dp[0][0], dp[0][1]);
        
        long mul = -1;
        
        for(int i = 1; i < sequence.length; i++){
            dp[i][0] = Math.max(mul * sequence[i], dp[i-1][0] + mul * sequence[i]);
            dp[i][1] = Math.max(-1 * mul * sequence[i], dp[i-1][1] + (-1 * mul * sequence[i]));
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
            
            mul *= -1;
        }
        
        // for(int i = 0; i < sequence.length; i++){
        //     System.out.println(dp[i][0] + " " + dp[i][1]);
        // }
        
        return max;
    }
}