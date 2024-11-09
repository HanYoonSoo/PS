import java.util.*;

class Solution {
    public int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < a.length; i++){
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        
        int result = 0;
        
        for(int key : map.keySet()){
            if(result > map.get(key) * 2){
                continue;
            }    
            
            int star = 0;
            
            for(int i = 0; i < a.length - 1; i++){
                if((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]){
                    star += 2;
                    i++;
                }
                
                result = Math.max(star, result);
            }
        }
        
        return result;
    }
}