import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int w : works) {
            pq.add(w);
        }
        
        for(int i = 0; i < n; i++) {
            int biggest = pq.poll();
            biggest--;
            
            pq.add(Math.max(0, biggest));
        }
        
        long result = 0;
        
        while(!pq.isEmpty()) {
            int num = pq.poll();
            result += num * num;
        }
        
        return result;
    }
}