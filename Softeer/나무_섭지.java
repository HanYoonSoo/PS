import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] grid;
    static int exitY;
    static int exitX;
    static int nY;
    static int nX;
    static List<int[]> ghosts;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        ghosts = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++){
                if(str[j].equals("D")){
                    exitY = i;
                    exitX = j;
                } else if(str[j].equals("N")){
                    nY = i;
                    nX = j;
                } else if(str[j].equals("#")){
                    grid[i][j] = 2;
                } else if(str[j].equals("G")){
                    ghosts.add(new int[]{i, j});
                }
            }
        }

        int[][] gVisited = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(gVisited[i], Integer.MAX_VALUE);
        }

        if(!ghosts.isEmpty()){
            int minGY = -1;
            int minGX = -1;
            int minD = Integer.MAX_VALUE;

            for(int[] ghost : ghosts){
                int compute = Math.abs(exitY - ghost[0]) + Math.abs(exitX - ghost[1]);
    
                if(minD > compute){
                    minD = compute;
                    minGY = ghost[0];
                    minGX = ghost[1];
                }
            }
            Queue<int[]> q = new LinkedList<>();
            gVisited[minGY][minGX] = 0;
            q.add(new int[]{minGY, minGX, 0});

            while(!q.isEmpty()) {
                int[] curr = q.poll();
                int y = curr[0];
                int x = curr[1];
                int time = curr[2];
    
                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                        
                    if(0 <= ny && ny < N && 0 <= nx && nx < M && gVisited[ny][nx] > time + 1) {
                        gVisited[ny][nx] = time + 1;
                        q.add(new int[]{ny, nx, time + 1});
                    }
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[nY][nX] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{nY, nX, 0});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int time = curr[2];
            
            if(y == exitY && x == exitX) {
                System.out.println("Yes");
                return;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && grid[ny][nx] != 2) {
                    if(gVisited[ny][nx] > time + 1) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx, time + 1});
                    }
                }
            }
        }

        System.out.println("No");
    }
}
