import java.util.*;

class Solution {
    
    List<Integer> nList;
    List<Set<Integer>> combs;
    
    public int solution(int n, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>();
        
        int N = ans.length;
        
        for(int i = 1; i <= n; i++){
            set.add(i);
        }
        
        for(int i = 0; i < N; i++){
            if(ans[i] == 0){
               for(int j = 0; j < 5; j++){
                   set.remove(q[i][j]);
               } 
            }
        }
        
        nList = new ArrayList<>(set);
        combs = new ArrayList<>();
        
        findCombinations(0, new HashSet<>());
        
        int answer = 0;
        
        for(Set<Integer> comb : combs){
            boolean compare = true;
            
            for(int i = 0; i < N; i++){
                int count = 0;
                for(int j = 0; j < 5; j++){
                    if(comb.contains(q[i][j]))
                        count++;
                }

                if(count != ans[i]){
                    compare = false;
                    break;
                }
            }
            
            if(compare){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void findCombinations(int idx, Set<Integer> set){
        if(set.size() == 5){
            combs.add(set);
            return;
        }
        
        for(int i = idx; i < nList.size(); i++){
            Set<Integer> nextSet = new HashSet<>(set);
            nextSet.add(nList.get(i));
            findCombinations(i + 1, nextSet);
        }
    }
}