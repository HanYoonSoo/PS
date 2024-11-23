import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int work : works){
            pq.add(work);
        }
        
        for(int i = 0; i < n; i++){
            if(!pq.isEmpty()){
                int num = pq.poll();
                if(num > 1)
                    pq.add(num - 1);
            }
        }
        
        long result = 0;
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            result += num * num;
        }
        
        return result;
    }
}