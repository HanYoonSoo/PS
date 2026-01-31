import java.util.*;

class Solution {    
    List<Set<Integer>> combinations = new ArrayList<>();
    List<Integer> numList;
    int N;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = ans.length;
        Set<Integer> possibleNum = new HashSet<>();
        
        for (int i = 1; i <= n; i++) {
            possibleNum.add(i);
        }
        
        for (int i = 0; i < N; i++) {
            if (ans[i] == 0) {
                for (int j = 0; j < 5; j++) {
                    possibleNum.remove(q[i][j]);
                }
            }
        }
        
        numList = new ArrayList<>(possibleNum);
        
        findCombinations(0, new HashSet<>());
        
        // System.out.println(combinations);
        
        int result = 0;
        
        for (Set<Integer> comb : combinations) {
            boolean possible = true;
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    if (comb.contains(q[i][j]))
                        count++;
                }
                if (count != ans[i]) {
                    possible = false;
                    break;
                }
            }
            if (!possible)
                continue;
            else {
                result++;
            }
        }
        
        return result;   
    }
    
    public void findCombinations(int idx, Set<Integer> set) {
        if (set.size() == 5) {
            combinations.add(set);
            return;
        }
        
        for (int i = idx; i < numList.size(); i++) {
            Set<Integer> newSet = new HashSet<>(set);
            newSet.add(numList.get(i));
            findCombinations(i + 1, newSet);
        }
    }
}