import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int N = topping.length;
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < N; i++){
            set.add(topping[i]);
                
            if(map.get(topping[i]) == 1){
                map.remove(topping[i]);
            } else{
                map.put(topping[i], map.get(topping[i]) - 1);
            }
            
            if(map.size() == set.size()){
                answer++;
            }
        }
        
        return answer;
    }
}