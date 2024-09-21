import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
    
        
        int time = 0;
        int sum = 0;
        
        PriorityQueue<int[]> workTime = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> startTime = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        for(int[] job : jobs){
            startTime.add(job);
        }
        
        while(!workTime.isEmpty() || !startTime.isEmpty()){
            while(!startTime.isEmpty() && startTime.peek()[0] <= time){
                workTime.add(startTime.poll());
            }
            
            if(workTime.isEmpty()){
                time = startTime.peek()[0]; 
            } else{
                int[] job = workTime.poll();
                sum += time - job[0] + job[1];
                time += job[1];
            }
            
            // System.out.println(time + " " + sum);
        }
        
        return sum / jobs.length;
    }
}

// 1
// 입력값 〉 [[5, 10], [6, 8], [14, 2], [11, 5], [100, 7]]
// 기댓값 〉 11

// 2
// 입력값 〉 [[0, 1], [2, 2], [2, 3]]
// 기댓값 〉 2

// 3
// 입력값 〉 [[0, 3], [4, 4], [5, 3], [7, 1]]
// 기댓값 〉 4