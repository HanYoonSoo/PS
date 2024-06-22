import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, 0});
        
        boolean[] visited = new boolean[y - x + 1];
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[0] == y){
                return curr[1];
            } 
            else{
                if(curr[0] * 3 <= y && !visited[curr[0] * 3 - x]){
                    q.add(new int[]{curr[0] * 3, curr[1] + 1});
                    visited[curr[0] * 3 - x] = true;
                } if(curr[0] * 2 <= y && !visited[curr[0] * 2 - x]){
                    q.add(new int[]{curr[0] * 2, curr[1] + 1});
                    visited[curr[0] * 2 - x] = true;
                } if(curr[0] + n <= y && !visited[curr[0] + n - x]){
                    q.add(new int[]{curr[0] + n, curr[1] + 1});
                    visited[curr[0] + n - x] = true;
                } 


            }
        }
        
        
        return -1;
    }
}