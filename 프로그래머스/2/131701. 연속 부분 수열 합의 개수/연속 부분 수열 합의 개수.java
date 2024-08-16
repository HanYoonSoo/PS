import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int N = elements.length;
        
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < N; j++){
                int sum = 0;
                for(int k = j; k < i + j; k++){
                    sum += elements[k % N];
                }
                set.add(sum);
                // System.out.println(sum);
            }
        }
        
        return set.size();
    }
}