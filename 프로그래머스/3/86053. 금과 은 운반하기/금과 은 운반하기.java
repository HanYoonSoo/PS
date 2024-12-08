class Solution {
    int N;
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        N = g.length;
        
        long left = 1L;
        long right = 400000000000000L;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            if(isPossible(a, b, g, s, w, t, mid)){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public boolean isPossible(int a, int b, int[] g, int[] s, int[] w, int[] t, long time){
        long total = 0;
        long totalG = 0;
        long totalS = 0;
        
        for(int i = 0; i < N; i++){
            long count = time / (2L * t[i]);
            
            if(time % (2L * t[i]) >= t[i])
                count++;
            
            long temp = Math.min(w[i] * count, g[i] + s[i]);
            
            total += temp;
            totalG += Math.min(temp, g[i]);
            totalS += Math.min(temp, s[i]);
        }
        
        return total >= (a + b) && totalG >= a && totalS >= b;
        
    }
}