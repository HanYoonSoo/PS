import java.util.*;

class Solution {
    int N;
    boolean[] visited;
    int[][] arr;
    double result = 0;
    int[] answer;
    public int[] solution(int[][] dice) {
        N = dice.length;
        visited = new boolean[N];
        arr = dice;
        
        answer = new int[N / 2];
        
        dfs(0, 0);
    
        return answer;
    }
    
    public void dfs(int idx, int count){
        if(count == N / 2){
            List<Integer> aDice = new ArrayList<>();
            List<Integer> bDice = new ArrayList<>();
            
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    aDice.add(i);
                } else{
                    bDice.add(i);
                }
            }
            
            Map<Integer, Integer> aCount = calculateScore(aDice);
            Map<Integer, Integer> bCount = calculateScore(bDice);
            
            int win = 0;
            int same = 0;
            int lose = 0;
            
            for(int aKey : aCount.keySet()){
                for(int bKey : bCount.keySet()){
                    if(aKey > bKey){
                        win += aCount.get(aKey) * bCount.get(bKey);
                    } else if(aKey == bKey){
                        same += aCount.get(aKey) * bCount.get(bKey);
                    } else{
                        lose += aCount.get(aKey) * bCount.get(bKey);
                    }
                }
            }
            
            double ratio = (double) win / (win + same + lose);
            
            if(result < ratio){
                result = ratio;
                
                for(int i = 0; i < N / 2; i++){
                    answer[i] = aDice.get(i) + 1;
                }
            }
            
            return;
        }
        
        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    
    public Map<Integer, Integer> calculateScore(List<Integer> idxList){
        List<Integer> score = new ArrayList<>();
        
        for(int i = 0; i < idxList.size(); i++){
            int idx = idxList.get(i);
            if(score.isEmpty()){
                for(int j = 0; j < 6; j++){
                    score.add(arr[idx][j]);
                }
            } else{
                int size = score.size();
                
                for(int j = 0; j < size; j++){
                    int num = score.remove(0);
                    for(int k = 0; k < 6; k++){
                        score.add(num + arr[idx][k]);
                    }
                }
            }
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0; i < score.size(); i++){
            count.put(score.get(i), count.getOrDefault(score.get(i), 0) + 1);
        }
        
        return count;
    }
    
}
