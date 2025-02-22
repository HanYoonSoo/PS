import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int count = 1;
        
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        while(!pq.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[1] != pq.peek()){
                q.add(curr);
            } else {
                if(curr[0] == location){
                    return count; 
                } else{
                    pq.poll();
                    count++;
                }
            }
        }
        
        return -1;
    }
}