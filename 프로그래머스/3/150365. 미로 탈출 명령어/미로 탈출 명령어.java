import java.util.LinkedList;
import java.util.Queue;

/**
 * n x m (x, y) -k-> (r, c)
 * dlru
 */
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    
    int[][] grid;
    boolean[][] visited;
    
    String[] str = {"d", "l", "r", "u"};
    
    public String solution(int n1, int m1, int x1, int y1, int r1, int c1, int k1) {
        grid = new int[n1 + 1][m1 + 1];
        visited = new boolean[n1 + 1][m1 + 1];
        
        int distance = Math.abs(x1 - r1) + Math.abs(y1 - c1);
        
        if(distance > k1)
            return "impossible";
        
        if((k1 - distance) % 2 == 1)
            return "impossible";
        
        // System.out.println("1");
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x1, y1, 0, ""));
        visited[x1][y1] = true;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
        
            
            if(curr.x == r1 && curr.y == c1 && curr.count == k1){
                return curr.s;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if(1 <= nx && nx <= n1 && 1 <= ny && ny <= m1){
                    // visited[nx][ny] = true;
                    if(Math.abs(nx - r1) + Math.abs(ny - c1) + curr.count > k1)
                        continue;
                    
                    q.add(new Node(nx, ny, curr.count + 1, curr.s.concat(str[i])));
                    break;
                }
            }
        }
        
        return "impossible";
    }
    
    public class Node{
        int x;
        int y;
        int count;
        String s;
        
        public Node(int x, int y, int count, String s){
            this.x = x;
            this.y = y;
            this.count = count;
            this.s = s;
        }
    }
}