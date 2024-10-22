import java.util.*;

class Solution {
    boolean[] visited;
    int N;
    int[] w;
    int[] d;
    int result = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        N = n;
        visited = new boolean[weak.length];
        w = weak;
        d = dist;
        
        Arrays.sort(d);
        
        dfs(0, 1, dist.length - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public void dfs(int fix, int count, int idx) {
        if (fix == w.length) {
            count--;
            result = Math.min(result, count);
            return;
        }
        
        if (idx < 0) {
            return;
        }
        
        List<Integer> check = new ArrayList<>();
        
        for (int i = 0; i < w.length; i++) {
            if (!visited[i]) {
                int point = w[i];
                
                check.add(i);
                visited[i] = true;
                fix++;
                
                int move = d[idx];
                int temp = 1;
                int currIdx = i;
                
                while (move > 0 && fix < w.length) {
                    if (visited[(currIdx + 1) % w.length])
                        break;
                    
                    int moveDiff = w[(currIdx + 1) % w.length] - w[currIdx];
                    
                    if (moveDiff < 0)
                        moveDiff += N;
                    
                    move -= moveDiff;
                    
                    if (move >= 0) {
                        temp++;
                        fix++;
                        
                        currIdx = (currIdx + 1) % w.length;
                        check.add(currIdx);
                        visited[currIdx] = true;
                    }
                }
                
                dfs(fix, count + 1, idx - 1);
                
                fix -= temp;
                
                for (int c : check)
                    visited[c] = false;
                
                check.clear();
            }
        }
    }
}
