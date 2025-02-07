import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] result = new int[2];
        
        Set<String> set = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        int N = gems.length;
        
        for(String gem : gems){
            set.add(gem);
        }
        
        int kind = set.size();
        
        int start = 0;
        int min = 1000000;
        
        for(int i = 0; i < N; i++){
            countMap.put(gems[i], countMap.getOrDefault(gems[i], 0) + 1);
            
            while(countMap.get(gems[start]) > 1){
                countMap.put(gems[start], countMap.get(gems[start]) - 1);
                start++;
            }
            
            if(countMap.size() == kind && min > (i - start)){
                min = i - start;
                result[0] = start + 1;
                result[1] = i + 1;
            }
        }
        
        return result;
    }
}