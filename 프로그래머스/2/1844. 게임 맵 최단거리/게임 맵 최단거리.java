import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[N][M];
        
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int y = curr[0];
            int x = curr[1];
            int count = curr[2];
            
            if(y == (N - 1) && x == (M - 1)){
                return count;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && maps[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, count + 1});
                }
            }    
        }
        
        return -1;
    }
}