import java.util.*;

// 최소 몇 번 이동인지 이므로 BFS
// 장애물이나 벽을 만날 때 까지 이동이 1번의 이동
// x, y 좌표를 표기하기 위한 Node 클래스 필요
// BFS를 위해 사용할 Queue 필요
class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;

    
    public int solution(String[] board) {
        int answer = 0;
        
        int start_x = -1, start_y = -1;
        
        N = board.length;
        M = board[0].length();
        
        
        for(int i = 0; i < N; i++){
            String str = board[i];
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'R'){
                    start_x = i;
                    start_y = j;
                    break;
                }
            }
            
            if(start_x != -1 && start_y != -1)
                break;
        }
        
        
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[start_x][start_y] = true;
        
        q.add(new Node(start_x, start_y, 0));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int count = curr.count;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                while(0 <= nx && nx < N && 0 <= ny && ny < M && board[nx].charAt(ny) != 'D'){
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                
                if(visited[nx][ny] || (x == nx && y == ny)){
                    continue;
                }
                
                if(board[nx].charAt(ny) == 'G'){
                    return count + 1;
                }else{
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, count + 1));
                }
            }
        }
        
        
        
        return -1;
    }
    
    static class Node{
        int x, y, count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}