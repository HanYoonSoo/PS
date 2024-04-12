import java.util.*;

class Solution {
    class Pair{
        String name;
        int remainTime;
        
        public Pair(String name, int remainTime){
            this.name = name;
            this.remainTime = remainTime;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        
        Arrays.sort(plans, ((o1, o2) -> {
           return convert(o1[1]) - convert(o2[1]); 
        }));
        
        Stack<Pair> stack = new Stack();
        
        int result_idx = 0;
        
        for(int i = 0; i < plans.length; i++){
            String name = plans[i][0];
            int currTime = convert(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            if(i == plans.length - 1){
                result.add(name);
            } else{
                stack.add(new Pair(name, playTime));
                
                int nextTime = convert(plans[i+1][1]);
                int remainTime = nextTime - currTime;
                
                while(!stack.isEmpty() && remainTime > 0){
                    Pair pair = stack.pop();
                    
                    int workTime = Math.min(remainTime, pair.remainTime);
                    
                    if(workTime == pair.remainTime){
                        result.add(pair.name);
                    } else{
                        stack.add(new Pair(pair.name, pair.remainTime - remainTime));
                    }
                    
                    remainTime -= workTime;
                }
            }
        }
        
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            result.add(pair.name);
        }
        
        return result.toArray(String[] :: new);
    }
    
    public int convert(String str){
        String[] time = str.split(":");
        
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}