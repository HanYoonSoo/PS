import java.util.*;

class Solution {
    
    public int solution(int[][] board) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        int N = board.length;
        
        int[][][] visited = new int[N][N][4];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, -1, 0});
        
        int result = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int y = curr[0];
            int x = curr[1];
            int dir = curr[2];
            int cost = curr[3];
            
            if(y == N - 1 && x == N - 1){
                result = Math.min(result, cost);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(0 <= ny && ny < N && 0 <= nx && nx < N && board[ny][nx] != 1){
                    int nextCost = cost;
                    
                    if(i == dir || dir == -1){
                        nextCost += 100;
                    } else{
                        nextCost += 600;
                    }
                    
                    if(visited[ny][nx][i] == 0 || visited[ny][nx][i] > nextCost){
                        visited[ny][nx][i] = nextCost;
                        q.add(new int[]{ny, nx, i, nextCost});
                    }
                }
            }
        }
        
        return result;
    }
}