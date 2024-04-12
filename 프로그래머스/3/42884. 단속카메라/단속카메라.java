import java.util.*;

class Solution {
    
    // 스케줄링 문제 같음
    // 모든 차량이 한번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치?
    // routes 이동하는 차량의 경로
    public int solution(int[][] routes) {
        Arrays.sort(routes, ((r1, r2) -> {
           if(r1[1] == r2[1]){
               return r1[0] - r2[0];
           } 
           return r1[1] - r2[1];
        }));
        
        int answer = 1;
        
        int end = routes[0][1];
        
        for(int i = 0; i < routes.length; i++){
            if(end < routes[i][0]){
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}