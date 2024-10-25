class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        // if(cookie.length == 1){
        //     return cookie[0];
        // }
        
        for(int i = 0; i < cookie.length - 1; i++){
            int lSum = cookie[i];
            int rSum = cookie[i + 1];
            
            int lIdx = i;
            int rIdx = i + 1;
            
            if(lSum == rSum){
                answer = Math.max(answer, rSum);
                // continue;
            }
            
            while(true){
                if(lIdx > 0 && lSum <= rSum){
                    lIdx--;
                    lSum += cookie[lIdx];
                } else if(rIdx + 1 < cookie.length && lSum >= rSum){
                    rIdx++;
                    rSum += cookie[rIdx];
                } else{
                    break;
                }
                
                if(lSum == rSum){
                    answer = Math.max(answer, rSum);
                }
            }
        }
        
        return answer;
    }
}