import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int s : scoville){
            pq.add(s);
        }
        
        int count = 0;
        while(pq.size() >= 2 && pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + b * 2);
            count++;
        }
        
        if(pq.isEmpty()){
            return -1;
        } else{
            if(pq.peek() >= K)
                return count;
            else
                return -1;
        }
    }
}