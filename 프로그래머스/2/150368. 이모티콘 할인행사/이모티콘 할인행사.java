import java.util.*;

class Solution {
    int[] sales = new int[]{10, 20, 30, 40};
    int[] rate;
    
    PriorityQueue<int[]> pq;
    
    public int[] solution(int[][] users, int[] emoticons) {
        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            
            return o2[0] - o1[0];
        });
        
        rate = new int[emoticons.length];
        
        dfs(0, users, emoticons);
        
        return pq.poll();
    }
    
    public void dfs(int idx, int[][] users, int[] emoticons){
        if(idx == emoticons.length){
            int total = 0;
            int count = 0;
            
            for(int i = 0; i < users.length; i++){
                int sum = 0;
                for(int j = 0; j < emoticons.length; j++){
                    if(users[i][0] <= rate[j]){
                        sum += (emoticons[j] * (100 - rate[j]) / 100);
                    }
                }
                
                if(sum >= users[i][1]){
                    count++;
                    sum = 0;
                }
                
                total += sum;
            }
            
            pq.add(new int[]{count, total});
            
            return;
        }
        
        for(int i = 0; i < 4; i++){
            rate[idx] = sales[i];
            dfs(idx + 1, users, emoticons);
        }
    }
}