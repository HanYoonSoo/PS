import java.util.*;

class Solution {
    int[][] grid = new int[][]{
        {1, 2, 4, 2, 3, 5, 4, 5, 6, 6, 7, 8},
        {2, 1, 2, 3, 2, 3, 5, 4, 5, 7, 6, 7},
        {4, 2, 1, 5, 3, 2, 6, 5, 4, 8, 7, 6},
        {2, 3, 5, 1, 2, 4, 2, 3, 5, 4, 5, 6},
        {3, 2, 3, 2, 1, 2, 3, 2, 3, 5, 4, 5},
        {5, 3, 2, 4, 2, 1, 5, 3, 2, 6, 5, 4},
        {4, 5, 6, 2, 3, 5, 1, 2, 4, 2, 3, 5},
        {5, 4, 5, 3, 2, 3, 2, 1, 2, 3, 2, 3},
        {6, 5, 4, 5, 3, 2, 4, 2, 1, 5, 3, 2},
        {6, 7, 8, 4, 5, 6, 2, 3, 5, 1, 2, 4},
        {7, 6, 7, 5, 4, 5, 3, 2, 3, 2, 1, 2},
        {8, 7, 6, 6, 5, 4, 5, 3, 2, 4, 2, 1}
    };
    
    int[][][] dp;
    String arr;
    
    public int solution(String numbers) {
        dp = new int[numbers.length()][12][12];
        arr = numbers;
        
        for(int i = 0; i < numbers.length(); i++){
            for(int j = 0; j < 12; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int result = dfs(0, 3, 5);
        
        return result;
    }
    
    public int dfs(int depth, int L, int R){
        if(depth == arr.length()){
            return 0;
        }
        
        if(dp[depth][L][R] != -1){
            return dp[depth][L][R];
        }
        
        int num = computeC(arr.charAt(depth));
        int result = Integer.MAX_VALUE;
        
        if(num != R){
            result = Math.min(dfs(depth + 1, num, R) + grid[L][num], result);
        }
        
        if(num != L){
            result = Math.min(dfs(depth + 1, L, num) + grid[R][num], result);
        }
        
        dp[depth][L][R] = result;
        
        return result;
    }
    
    public int computeC(char c){
        int num = -1;
            
            if(c == '*'){
                num = 9;    
            } else if(c == '0'){
                num = 10;
            } else if(c == '#'){
                num = 11;
            } else{
                num = c - '1';
            }
        
        return num;
    }
}