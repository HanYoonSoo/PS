import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];

        int startY = 0;
        int startX = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 2){
                    startY = i;
                    startX = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX, 0});

        int[][] visited = new int[N][M];
        visited[startY][startX] = 0;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int count = curr[2];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == 0 && grid[ny][nx] == 1){
                    visited[ny][nx] = count + 1;
                    q.add(new int[]{ny, nx, visited[ny][nx]});
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    visited[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
