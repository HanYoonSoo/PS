import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int[] index = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            index[i] = i;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i = 0; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[index[stack.peek()]] < numbers[i]){
                answer[index[stack.peek()]] = numbers[i];
                stack.pop();
            }
            stack.add(i);
        }
        
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        return answer;
    }
}