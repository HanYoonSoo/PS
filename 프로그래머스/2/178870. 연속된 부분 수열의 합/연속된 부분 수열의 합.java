import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int idx = 0;
        int minLen = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < sequence.length; i++){
            sum += sequence[i];
            
            if(sum == k){
                if(minLen > (i - idx + 1)){
                    minLen = i - idx + 1;
                    left = idx;
                    right = i;
                }            
            } else if(sum > k){
                while(sum > k){
                    sum -= sequence[idx++];
                }
                if(sum == k){
                    if(minLen > (i - idx + 1)){
                        minLen = i - idx + 1;
                        left = idx;
                        right = i;
                    }
                }
            }
        }
        
        return new int[]{left, right};
    }
}