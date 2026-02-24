import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean compare = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> possible = new ArrayList<>();
                        possible.add(new int[]{i, j});
                        int total = bfs(i, j, possible, visited);

                        if (possible.size() > 1) {
                            compare = true;
                            for (int[] elements : possible) {
                                grid[elements[0]][elements[1]] = total / possible.size();
                            }
                        }
                    }
                }
            }

            if (!compare)
                break;

            count++;
        }

        System.out.println(count);
    }

    public static int bfs(int y, int x, List<int[]> possible, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        q.add(new int[]{y, x});
        visited[y][x] = true;

        int total = grid[y][x];

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                    if (isPossible(curr[0], curr[1], ny, nx)) {
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        possible.add(new int[]{ny, nx});
                        total += grid[ny][nx];
                    }
                }
            }
        }

        return total;
    }

    public static boolean isPossible(int y, int x, int ny, int nx) {
        return ( Math.abs(grid[y][x] - grid[ny][nx]) >= L && Math.abs(grid[y][x] - grid[ny][nx]) <= R );
    }
}
