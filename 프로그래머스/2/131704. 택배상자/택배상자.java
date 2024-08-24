import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int idx = 0;
        
        for(int i = 1; i <= order.length; i++){
            if(order[idx] == i){
                idx++;
                answer++;
            } else if(!stack.isEmpty() && stack.peek() == order[idx]){
                idx++;
                answer++;
                i--;
                stack.pop();
            } else{
                stack.add(i);
            }
        }
        
        while(!stack.isEmpty()){
            if(stack.peek() == order[idx]){
                stack.pop();
                idx++;
                answer++;
            } else{
                break;
            }
        }
    
        
        return answer;
    }
}