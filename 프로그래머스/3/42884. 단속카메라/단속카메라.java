import java.util.*;

class Solution {
    
    // 스케줄링 문제 같음
    // 모든 차량이 한번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치?
    // routes 이동하는 차량의 경로
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int end = routes[0][1];
        int count = 1;
        
        for(int i = 1; i < routes.length; i++){
            if(end < routes[i][0]){
                end = routes[i][1];
                count++;
            }
        }
        
        return count;
    }
}