class Solution {
    public int[] solution(int e, int[] starts) {
        int[] count = new int[5000001];
        
        for(int i = 1; i <= e; i++){
            count[i] = 1;
        }
        
        for(int i = 2; i <= e; i++){
            for(int j = 1; j <= e; j++){
                if(i * j > e)
                    break;
                count[i * j]++;
            }
        }
        
        int[] dp = new int[e + 1];
        
        int maxIdx = e;
        
        for(int i = e; i >= 1; i--){
            if(count[i] >= count[maxIdx])
                maxIdx = i;
            dp[i] = maxIdx;
        }
        
        int[] result = new int[starts.length];
        
        for(int i = 0; i < starts.length; i++){
            result[i] = dp[starts[i]];
        }
        
        return result;
        
        
    }
}