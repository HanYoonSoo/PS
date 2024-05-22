import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && grid[i][j] != 1){
                    max = Math.max(max, bfs(i, j, visited));

//                    System.out.println(max);
                }
            }
        }

        System.out.println(max);
    }

    private static int bfs(int y, int x, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[y][x] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{y, x});

        int score = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cy = curr[0];
            int cx = curr[1];

            if(grid[cy][cx] == 0){
                score += 1;
            } else if(grid[cy][cx] == 2){
                score -= 2;
            }

            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N && !visited[ny][nx] && grid[ny][nx] != 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return score;
    }
}
