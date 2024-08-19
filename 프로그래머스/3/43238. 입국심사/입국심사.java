import java.util.*;

class Solution {
    public long solution(int n, int[] times) {

        long left = 1;
        
        long max = 0;
        for(int time : times){
            max = Math.max(max, time);
        }
        
        long right = max * n;
        // long result = 0;
        
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long count = 0;
    
            for(int time : times){
                count += (mid / time);
            }
            
            if(count < n){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
            
        }
        return left;
    }
}