import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {   
        int maxAlp = 0;
        int maxCop = 0;
        
        for(int[] problem : problems){
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
        }
        
        if(alp >= maxAlp && cop >= maxCop){
            return 0;
        }
        
        int targetAlp = 0;
        int targetCop = 0;
        
        targetAlp = Math.max(alp, maxAlp);
        targetCop = Math.max(cop, maxCop);
        
        int[][] dp = new int[151][151];
        
        for(int i = 0; i <= 150; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= targetAlp; i++){
            for(int j = cop; j <= targetCop; j++){
                if(i + 1 <= 150)
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                
                if(j + 1 <= 150)
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for(int[] problem : problems){
                    if(i >= problem[0] && j >= problem[1]){
                        if(i + problem[2] < targetAlp && j + problem[3] < targetCop){
                            dp[i + problem[2]][j + problem[3]] = Math.min(dp[i + problem[2]][j + problem[3]], dp[i][j] + problem[4]);
                        } else if(i + problem[2] < targetAlp){
                            dp[i + problem[2]][targetCop] = Math.min(dp[i + problem[2]][targetCop], dp[i][j] + problem[4]);
                        } else if(j + problem[3] < targetCop){
                            dp[targetAlp][j + problem[3]] = Math.min(dp[targetAlp][j + problem[3]], dp[i][j] + problem[4]);
                        } else if(i + problem[2] >= targetAlp && j + problem[3] >= targetCop){
                            dp[targetAlp][targetCop] = Math.min(dp[targetAlp][targetCop], dp[i][j] + problem[4]);
                        }
                    }
                }
            }
        }
        
        return dp[targetAlp][targetCop];
        
    }
}