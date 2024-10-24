import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            String[] num = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(num[j]);
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
        }

        int total = 0;

        for (int i = min; i <= max; i++) {
            for (int j = 1; j < N - 1; j++) {
                for (int k = 1; k < M - 1; k++) {
                    if (grid[j][k] == i) {
                        total += bfs(j, k, i);
                    }
                }
            }
        }

        System.out.println(total);
    }

    public static int bfs(int y, int x, int H) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        grid[y][x] = H + 1; 

        int count = 1; 
        boolean isPossible = true; 

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curY = curr[0], curX = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || grid[ny][nx] < H) {
                    isPossible = false; 
                    continue;
                }

                if (!visited[ny][nx] && grid[ny][nx] == H) {
                    visited[ny][nx] = true;
                    grid[ny][nx] = H + 1; 
                    count++;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return isPossible ? count : 0;
    }
}
