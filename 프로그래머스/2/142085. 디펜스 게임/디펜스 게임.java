import java.util.*;

class Solution {
    // 무적권을 사용하면 그 라운드의 모든 병사를 막을 수 있음.
    // N은 병사의 수, K는 무적권의 개수
    // 모든 라운드를 막을 수 있는 경우에는 enemy[i] 길이 return
    // 몇 라운드까지 막을 수 있는지 return
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length){
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n < 0 && k > 0){
                n += pq.poll();
                k--;
            } else if(n < 0 && k <= 0)
                return i;
        }
        
        return enemy.length;
    }
}