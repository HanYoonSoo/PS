class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for(int coin : money){
            for(int i = 1; i <= n; i++){
                if(i - coin >= 0){
                    dp[i] += dp[i - coin];
                }        
            }
        }     
        
        return dp[n];
    }
}