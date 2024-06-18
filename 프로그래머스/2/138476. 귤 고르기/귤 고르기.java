import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> fruitCount = new HashMap<>();

        for(int fruit : tangerine){
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);    
        }

        List<Integer> keys = new ArrayList<>(fruitCount.keySet());

        Collections.sort(keys, (o1, o2) -> {
           return fruitCount.get(o2) - fruitCount.get(o1); 
        });

        for(int key : keys){
            if(k <= 0)
                break;

            answer++;
            k -= fruitCount.get(key);
        }

        return answer;
    }
}