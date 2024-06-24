import java.util.*;

class Solution {
    int[] sales = {10, 20, 30, 40};
    PriorityQueue<int[]> pq;
    int[] rate;
    
    public int[] solution(int[][] users, int[] emoticons) {
        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o2[0] - o1[0];
        });
        rate = new int[emoticons.length];
        
        perm(0, users, emoticons);
        
        return pq.poll();
    }
    
    public void perm(int idx, int[][] users, int[] emoticons){
        if(idx == rate.length){
            int total = 0;
            int service = 0;
            
            for(int i = 0; i < users.length; i++){
                int sum = 0;
                
                for(int j = 0; j < rate.length; j++){
                    if(users[i][0] <= rate[j]){
                        sum += emoticons[j] * (100 - rate[j]) / 100;
                    } 
                }
                
                if(sum >= users[i][1]){
                    service++;
                    sum = 0;
                }
                
                // System.out.println(sum);
                
                total += sum;
            }
            pq.add(new int[]{service, total});
            
            return;
        }
        
        for(int i = 0; i < sales.length; i++){
            rate[idx] = sales[i];
            perm(idx + 1, users, emoticons);
        }
    }
}