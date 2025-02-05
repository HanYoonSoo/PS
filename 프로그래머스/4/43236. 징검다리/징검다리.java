import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        int result = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int remove = 0;
            int prev = 0;
            
            for(int rock : rocks){
                if(rock - prev < mid){
                    remove++;
                } else
                    prev = rock;
            }
            
            if(distance - prev < mid){
                remove++;
            }
            
            if(remove <= n){
                result = mid;
                left = mid + 1;            
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}