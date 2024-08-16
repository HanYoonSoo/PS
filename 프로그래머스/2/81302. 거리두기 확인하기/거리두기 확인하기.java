import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        
        for(String[] place : places){
            if(bfs(place)){
                answer[idx++] = 1;        
            } else{
                answer[idx++] = 0;
            }
        }
        
        return answer;
    }
    
    public boolean bfs(String[] place){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        List<int[]> persons = new ArrayList<>();
        
        for(int i = 0; i < 5; i++){
            String[] line = place[i].split("");
            for(int j = 0; j < 5; j++){
                if(line[j].equals("P")){
                    // persons.add(new int[]{i, j});
                    persons.add(new int[]{i, j});
                }
            }
        }
        
        for(int[] person : persons){
            Queue<int[]> q = new LinkedList<>();
            int[][] visited = new int[5][5];
            
            int orgY = person[0];
            int orgX = person[1];
            
            q.add(new int[]{orgY, orgX});
            visited[orgY][orgX] = 0;
            
            while(!q.isEmpty()){
                int[] curr = q.poll();
                int y = curr[0];
                int x = curr[1];


                if(visited[y][x] > 2){
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    // System.out.println(orgY + " " + ny + " " + orgX + " " + nx);
                    if(0 <= ny && ny < 5 && 0 <= nx && nx < 5 && (orgY != ny || orgX != nx) && visited[ny][nx] == 0 && place[ny].charAt(nx) != 'X'){
                        // System.out.println("111111111");
                        visited[ny][nx] = visited[y][x] + 1;
                        if(visited[ny][nx] <= 2 && place[ny].charAt(nx) == 'P'){
                            return false;
                        }

                        // System.out.println(visited[ny][nx]);
                        q.add(new int[]{ny, nx});
                    }
                }
            }
            
            // for(int i = 0; i < 5; i++){
            //     for(int j = 0; j < 5; j++){
            //         System.out.print(visited[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        
        return true;
    }
}