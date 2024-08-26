import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int N = gems.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        int kind = Arrays.stream(gems).distinct().toArray().length;
        int start = 0;
        int end = 0;
        int min = 100000;
        
        for(end = 0; end < N; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if(map.size() == kind && min > (end - start)){
                min = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        
        
        return answer;
    }
}