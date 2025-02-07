import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        String[] str = s.split("");
        
        Stack<String> stack;
        
        for(int i = 0; i < s.length(); i++){
            stack = new Stack<>();
            
            boolean compare = false;
            
            for(int j = 0; j < s.length(); j++){
                if(str[j].equals("[") || str[j].equals("(") || str[j].equals("{")){
                    stack.add(str[j]);
                } else{
                    if(stack.isEmpty()){
                        compare = true;
                        break;
                    } else if(str[j].equals("]") && !stack.peek().equals("[")){
                        compare = true;
                        break;
                    } else if(str[j].equals(")") && !stack.peek().equals("(")){
                        compare = true;
                        break;
                    } else if(str[j].equals("}") && !stack.peek().equals("{")){
                        compare = true;
                        break;
                    } else {
                        stack.pop();
                    } 
                }
            }
            
            if(stack.isEmpty() && !compare){
                count++;
            }
            
            String temp = str[0];
            for(int j = 0; j < s.length(); j++){
                str[j] = str[(j + 1) % s.length()];    
            }
            str[s.length() - 1] = temp;
            
        }
        
        return count;
    }
}