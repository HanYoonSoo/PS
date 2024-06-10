import java.util.*;

class Solution {
    String[][] grid;
    boolean[][] visited;
    
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    int startY = 0;
    int startX = 0;
    
    int laberY = 0;
    int laberX = 0;
    
    int targetY = 0;
    int targetX = 0;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        grid = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            grid[i] = maps[i].split("");
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j].equals("S")){
                    startY = i;
                    startX = j;
                } else if(grid[i][j].equals("L")){
                    laberY = i;
                    laberX = j;
                } else if(grid[i][j].equals("E")){
                    targetY = i;
                    targetX = j;
                }
            } 
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{startY, startX, 0});
        
        visited[startY][startX] = true;
        
        int laberDistance = 0;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int y = curr[0];
            int x = curr[1];
            int curCount = curr[2];
            
            if(y == laberY && x == laberX){
                laberDistance = curCount;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(0 <= ny && ny < grid.length && 0 <= nx && nx < grid[0].length && !grid[ny][nx].equals("X")){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx, curCount + 1});
                    }
                }
            }
        }
        
        if(laberDistance == 0){
            return -1;
        }
        
        int targetDistance = 0;
        
        q = new LinkedList<>();
        
        q.add(new int[]{laberY, laberX, 0});
        
        visited = new boolean[grid.length][grid[0].length];
        
        visited[laberY][laberX] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int y = curr[0];
            int x = curr[1];
            int curCount = curr[2];
            
            if(y == targetY && x == targetX){
                targetDistance = curCount;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(0 <= ny && ny < grid.length && 0 <= nx && nx < grid[0].length && !grid[ny][nx].equals("X")){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx, curCount + 1});
                    }
                }
            }
        }
        
        if(targetDistance == 0){
            return -1;
        }
        
        // System.out.println(laberDistance);
        // System.out.println(targetDistance);
        return (laberDistance + targetDistance); 
    }
}