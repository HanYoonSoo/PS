import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] weightCnt = new long[1001];
        long[] weightDisCnt = new long[4001];
        
        for(int i = 0; i < weights.length; i++){
            int d2 = weights[i] * 2;
            int d3 = weights[i] * 3;
            int d4 = weights[i] * 4;
            
            if(weightCnt[weights[i]] > 0){
                answer += weightCnt[weights[i]];
                
                answer += weightDisCnt[d2] - weightCnt[weights[i]];
                answer += weightDisCnt[d3] - weightCnt[weights[i]];
                answer += weightDisCnt[d4] - weightCnt[weights[i]];
                
            } else {
                answer += weightDisCnt[d2];
                answer += weightDisCnt[d3];
                answer += weightDisCnt[d4];
            }
            
            weightCnt[weights[i]]++;
            weightDisCnt[d2]++;
            weightDisCnt[d3]++;
            weightDisCnt[d4]++;

        }
        
        
        return answer;
    }
}