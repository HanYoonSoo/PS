import java.util.*;

class Solution {
    
    static class Time implements Comparable<Time>{
        int start;
        int end;
        
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Time t){
            if(this.start == t.start){
                return this.end - t.end;
            }
            return this.start - t.start;
        }
    }
    public int solution(String[][] book_time) {
        // book_time = new String[][]{
        //     {"10:00", "10:10"}};
        
        int answer = 0;
        
        List<Time> times = new ArrayList<>();
        
        for(String[] str : book_time){
            String[] time = str[0].split(":");
            
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            
            int start = hour * 60 + minute;
            
            time = str[1].split(":");
            
            hour = Integer.parseInt(time[0]);
            minute = Integer.parseInt(time[1]);
            
            int end = hour * 60 + minute;
            
            times.add(new Time(start, end));    
        }
        
        Collections.sort(times);
        
        int count = 0;
        
        int end = times.get(0).end;
        
        List<Integer> rooms = new ArrayList<>();
        
        for(Time time : times){
            Collections.sort(rooms);
            
            boolean compare = false;
            
            for(int i = 0; i < rooms.size(); i++){
                if(rooms.get(i) <= time.start){
                    rooms.set(i, time.end + 10);
                    compare = true;
                    break;
                }
            }
            
            if(!compare){
                rooms.add(time.end + 10);
            }   
        }
        
        System.out.println(rooms.size());
        
        return rooms.size();
    }
}

// {"00:00", "00:07"}, {"00:01", "00:08"}, {"00:02", "00:09"}, {"10:26", "10:41"}
// {"10:00", "10:20"}, {"09:00", "09:20"}, {"09:20", "09:40"}, {"09:40", "10:00"}]