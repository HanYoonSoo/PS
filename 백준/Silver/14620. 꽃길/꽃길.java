import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    public static void dfs(int count, int total){
        if(count == 3){
            min = Math.min(total, min);
            return;
        }

        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < N - 1; j++) {
                if (!visited[i][j] && checkAround(i, j)) {
                    visited[i][j] = true;

                    int sum = grid[i][j];

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        visited[ny][nx] = true;
                        sum += grid[ny][nx];
                    }

                    dfs(count + 1, total + sum);

                    visited[i][j] = false;

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        visited[ny][nx] = false;
                    }
                }
            }
        }
    }

    public static boolean checkAround(int y, int x){
        for(int i = 0; i < 4; i++){
            if(visited[y + dy[i]][x + dx[i]]){
                return false;
            }
        }

        return true;
    }
}
