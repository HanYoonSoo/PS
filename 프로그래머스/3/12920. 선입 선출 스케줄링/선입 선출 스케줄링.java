import java.util.*;

class Solution {
     public static int solution(int n, int[] cores) {
        int answer = 0;

        int min = 0; // 시간의 최소값
        int max = 10000*n; // 시간의 최대값

        int time = 0;
        int m = 0; // time까지 처리한 작업량

        while (min <= max) {  
            int mid = (min+max)/2;

            int count = CountWork(mid, cores);
            // System.out.println(count);
            
            if (count >= n) { // 해당시간까지 처리한 작업량보다 n이 크면 time과 m갱신
                max = mid-1;   
                time = mid;     
                m = count; 
            }else{
                min = mid+1;
            }
        }

        m-=n; // 처리한 작업량과 n의 차이 갱신
        for(int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) { // 시간이 time일때, 작업을 처리하는 core
                if (m == 0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }

        return answer;
    }

    static int CountWork(int time, int[] cores){

        if (time == 0) { // 시간이 0일 때, 처리할 수 있는 작업량은 코어의 개수 
            return cores.length;
        }

        int count = cores.length; // 시간이 0일 때, 처리한 작업량 

        for(int i = 0; i<cores.length; i++){ // time까지 코어가 처리할 수 있는 작업량 합산
            count += (time/cores[i]);
        }

        return count;
    }
}