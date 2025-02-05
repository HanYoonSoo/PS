// bridge_length: 다리에 올라갈 수 있는 트럭의 개수
// weight: 다리가 버틸 수 있는 무게
// truck_weights: 각 트럭의 무게
// 순서가 정해져 있을 때 건널 수 있는 최단 시간

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                if(q.isEmpty()){
                    sum += truck;
                    q.add(truck);
                    time++;
                    break;
                }
                else if(q.size() == bridge_length){
                    sum -= q.poll();
                }
                else{
                    if((sum + truck) <= weight){
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{
                        q.add(0);
                        time++;
                    }
                
                }
                
                
            }
        }
        
        
        return time + bridge_length;
    }
}

