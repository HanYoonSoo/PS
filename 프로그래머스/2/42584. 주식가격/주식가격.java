import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]){
                int[] curr = stack.pop();
                answer[curr[0]] = i - curr[0];
            }
            
            stack.add(new int[]{i, prices[i]});
        }
        
        int N = prices.length - 1;
        
        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            answer[curr[0]] = N - curr[0];
        }
        
        return answer;
    }
}