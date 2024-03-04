import java.util.*;

// A나라의 미사일은 X축에 평행하게 좌표로 주어짐
// B나라에서 최소한의 미사일을 사용하여 요격
// 시간복잡도 O(N^2) <= O(X) <= O(NlogN)예상
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int count = 1;
        int end = targets[0][1];
        
        for(int[] target : targets){
            if(end <= target[0]){
                end = target[1];
                count++;
            }
        }
        
        return count;
    }
}