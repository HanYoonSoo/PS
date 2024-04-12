class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long max = 0;
        
        int N = sequence.length;
        long[][] DP = new long[N][2];
        
        DP[0][0] = sequence[0];
        DP[0][1] = -1 * sequence[0];
        
        max = Math.max(DP[0][0], DP[0][1]);
        
        for(int i = 1; i < sequence.length; i++){
            DP[i][0] = Math.max(sequence[i], DP[i-1][1] + sequence[i]);
            DP[i][1] = Math.max(-sequence[i], DP[i-1][0] - sequence[i]);
            
            max = Math.max(max, DP[i][0]);
            max = Math.max(max, DP[i][1]);
        }
        
        return max;
    }
}