import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {    
        int count = 0;
        
        int idx = 0;
        
        for(int i = 1; i <= n; i++){
            if(idx >= stations.length){
                i = w * 2 + i;
                count++;
                continue;
            }
            
            if(i < stations[idx] - w){
                i = w * 2 + i;
                count++;
            } else{
                i = stations[idx] + w;
                idx++;
            }
        }

        return count;
    }
}