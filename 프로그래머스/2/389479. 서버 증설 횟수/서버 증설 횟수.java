import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<int[]> q = new LinkedList<>();
        
        int maxHuman = m;
        int update = 0;
        
        for (int i = 0; i < players.length; i++) {
            if (!q.isEmpty()) {
                if(q.peek()[0] == i) {
                    maxHuman -= q.poll()[1];
                }
            }
            int currentUser = players[i];
            
            if (maxHuman <= currentUser) {
                int need = (currentUser - maxHuman) / m + 1;
                update += need;
                maxHuman += need * m;
                q.add(new int[]{i + k, need * m});
            }
        }
        
        return update;
    }
}