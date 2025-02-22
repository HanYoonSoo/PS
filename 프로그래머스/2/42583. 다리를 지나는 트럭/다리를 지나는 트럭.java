// bridge_length: 다리에 올라갈 수 있는 트럭의 개수
// weight: 다리가 버틸 수 있는 무게
// truck_weights: 각 트럭의 무게
// 순서가 정해져 있을 때 건널 수 있는 최단 시간

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        int sum = 0;
        int time = 0;
        int idx = 0;
        
        while(true){
            if(q.size() == bridge_length){
                int curr = q.poll();      
                time++;
                
                if(curr != 0){
                    sum -= curr;
                }
            }
            
            if(idx < truck_weights.length){
                if(sum + truck_weights[idx] <= weight){
                    sum += truck_weights[idx];
                    q.add(truck_weights[idx++]);
                } else {
                    q.add(0);
                }
            } else if(sum == 0 || q.isEmpty()) {
                break;
            } else {
                q.add(0);
            }
        }
        
        while(!q.isEmpty()){
            int num = q.poll();
            time++;
        }
        
        return time;
    }
}

