import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> q = new LinkedList<>();
        
        int busStart = 60 * 9;
        for(int i = 0; i < n; i++){
            q.add(busStart);
            busStart += t;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String time : timetable){
            String[] temp = time.split(":");
            int hour = Integer.parseInt(temp[0]);
            int minute = Integer.parseInt(temp[1]);
            
            pq.add(hour * 60 + minute);
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            while(!pq.isEmpty() && q.peek() >= pq.peek()){
                int time = pq.poll();
                count++;
                
                if(count == m){
                    int last = q.poll();
                    count = 0;
                    if(q.isEmpty()){
                        return computeTime(time - 1);
                    }
                }
            }
            
            if(pq.isEmpty() && count < m){
                return computeTime(q.peek());
            } else if(q.size() == 1 && q.peek() < pq.peek()){
                return computeTime(q.peek());
            }
            
            count = 0;
            q.poll();
        }
        
        return "-1";
    }
    
    public String computeTime(int time){
        int hour = time / 60;
        int minute = time % 60;
        
        String h;
        String m;
        
        if(hour < 10){
            h = "0" + hour;
        } else{
            h = "" + hour;
        }
        
        if(minute < 10){
            m = "0" + minute;
        } else{
            m = "" + minute;
        }
        
        return h + ":" + m;
    }
    
    
}