import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int[][] move = {{1, -1}, {-1, -1},  {-1, 1}, {1, 1}};
    static int N;
    static int M;
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N < 2 && M < 2){
            System.out.println(0);
            return;
        }

        visited = new boolean[N][M];

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int idx, int sum){
        if(idx == N * M){
            result = Math.max(result, sum);
            return;
        }

        int r = idx / M;
        int c = idx % M;

        if(!visited[r][c]){
            for(int i = 0; i < 4; i++){
                int ny = r + move[i][0];
                int nx = c + move[i][1];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][c] && !visited[r][nx]){
                    visited[r][c] = true;
                    visited[ny][c] = true;
                    visited[r][nx] = true;

                    int compute = (grid[r][c] * 2 + grid[ny][c] + grid[r][nx]);

                    dfs(idx + 1, sum + compute);

                    visited[r][c] = false;
                    visited[ny][c] = false;
                    visited[r][nx] = false;
                }
            }
        }

        dfs(idx + 1, sum);

    }
}
