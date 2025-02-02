class Solution {
    int N;
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        N = t.length;    
        
        long left = 0L;
        long right = (long) Math.pow(10, 14) * 4;
        
        long result = 0L;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            if(isPossible(mid, a, b, g, s, w, t)){
                result = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t){
        long total = 0;
        long totalG = 0;
        long totalS = 0;
        
        for(int i = 0; i < N; i++){
            long count = time / (2L * t[i]);
            
            if(time % (2L * t[i]) >= t[i])
                count++;
            
            long temp = Math.min(count * w[i], g[i] + s[i]);
            
            total += temp;
            totalG += Math.min(temp, g[i]);
            totalS += Math.min(temp, s[i]);
        }
        
        return total >= (a + b) && totalG >= a && totalS >= b;
    }
}