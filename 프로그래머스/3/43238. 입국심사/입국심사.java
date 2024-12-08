import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        
        long max = 1000000000 * n;
        for(int time : times){
            max = Math.max(max, time);
        }
        
        long right = max * n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long sum = 0;
            
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];    
            }
            
            if(sum >= n){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        
    }
}