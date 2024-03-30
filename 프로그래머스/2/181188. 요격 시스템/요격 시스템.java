import java.util.*;

// A나라의 미사일은 X축에 평행하게 좌표로 주어짐
// B나라에서 최소한의 미사일을 사용하여 요격
// 시간복잡도 O(N^2) <= O(X) <= O(NlogN)예상
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (t1, t2) -> {
            if(t1[1] == t2[1]){
                return t1[0] - t2[0];
            }
            return t1[1] - t2[1];
        });
        
        int count = 1;
        
        int end = targets[0][1];
        
        for(int[] target : targets){
            int start = target[0];
            
            if(end <= start){
                count++;
                end = target[1];
            }
        }
        
        return count;
    }
}
