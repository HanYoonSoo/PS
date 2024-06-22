import java.util.*;

class Solution {
    public Integer[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        String[][] grid = new String[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            grid[i] = maps[i].split("");
        }
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(!grid[i][j].equals("X") && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    
                    int sum = 0;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int y = curr[0];
                        int x = curr[1];
                        
                        sum += Integer.parseInt(grid[y][x]);
                        
                        for(int k = 0; k < 4; k++){
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            
                            if(0 <= ny && ny < maps.length && 0 <= nx && nx < maps[0].length() && !visited[ny][nx] && !grid[ny][nx].equals("X")){
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    
                    answer.add(sum);
                }
            }
        }
        
        Collections.sort(answer);
        
        Integer[] result = answer.toArray(new Integer[0]);
        
        if(answer.isEmpty()){
            return new Integer[]{-1};
        }
        
        return result;
    }
}