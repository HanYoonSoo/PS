import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(String operation : operations){
            String[] arr = operation.split(" ");
            
            String command = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if(command.equals("I")){
                min.add(num);
                max.add(num);
            } else{
                if(!min.isEmpty()){
                    if(num == 1){
                        int remove = max.poll();
                        min.remove(Integer.valueOf(remove));
                    } else{
                        int remove = min.poll();
                        max.remove(Integer.valueOf(remove));
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        
        if(min.isEmpty()){
            answer = new int[]{0, 0};
        } else{
            answer = new int[]{max.poll(), min.poll()};
        }
        
        return answer;
    }
}