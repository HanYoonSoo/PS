import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int answer = citations.length;
        
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= answer){
                break;
            } else{
                answer--;
            }
        }
        
        return answer;
    }
}

// 0 1 3 5 6