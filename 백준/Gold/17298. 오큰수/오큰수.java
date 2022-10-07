
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int size = Integer.parseInt(br.readLine());
    	String[] str = br.readLine().split(" ");
    	StringBuilder sb = new StringBuilder();
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> result = new Stack<Integer>();
    	Stack<Integer> temp = new Stack<Integer>();
    	
    	for(int i=0; i<size; i++) {
    		stack.add(Integer.parseInt(str[i]));
    	}
    	
    	while(!stack.isEmpty()) {
    		if(temp.isEmpty()) {
    			result.add(-1);
    			temp.add(stack.pop());
    		}else {
    			if(stack.peek() < temp.peek()) {
    				result.add(temp.peek());
    				temp.add(stack.pop());
    			}else {
    				temp.pop();
    			}
    		}
    	}
    	
    	while(!result.isEmpty()) {
    		sb.append(result.pop()).append(" ");
    	}
    	
    	System.out.print(sb.toString());
    }
}

