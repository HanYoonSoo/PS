import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        
        long sumLeft = 0;
        long sumRight = 0;
        
        int N = queue1.length;
        
        for(int i = 0; i < N; i++){
            sumLeft += queue1[i];
            left.add(queue1[i]);
            
            sumRight += queue2[i];
            right.add(queue2[i]);
        }
        
        long mid = (sumLeft + sumRight) / 2;
        
        int count = 0;
        
        while(count <= 2 * N + 2 && sumLeft != mid && sumRight != mid){
            count++;
            
            if(sumLeft < sumRight){
                int num = right.poll();
                sumRight -= num;
                
                left.add(num);
                sumLeft += num;
            } else if(sumLeft > sumRight){
                int num = left.poll();
                sumLeft -= num;
                
                right.add(num);
                sumRight += num;
            }
        }
        
        if(sumLeft == mid && sumRight == mid){
            return count;
        } else {
            return -1;
        }
    }
}