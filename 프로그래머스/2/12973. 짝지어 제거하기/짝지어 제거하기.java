import java.util.*;

class Solution {
    public int solution(String s) {
        String[] sArr = s.split("");
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < sArr.length; i++){
            if(!stack.isEmpty() && stack.peek().equals(sArr[i])){
                stack.pop();
                continue;
            }
            
            stack.add(sArr[i]);
        }
        
        if(stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }
}