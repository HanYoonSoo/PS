import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int turn = 1;
        
        Set<String> already = new HashSet<>();
        
        already.add(words[0]);
        
        for(int i = 2; i <= words.length; i++){
            String before = words[(i - 1) - 1];
            String curr = words[i - 1];
            if(before.charAt(before.length() - 1) != curr.charAt(0) || already.contains(curr)){
                return new int[]{i % n == 0 ? n : i % n, (i - 1) / n + 1};
            }
            already.add(curr);
        }
        
        return new int[]{0, 0};
    }
}