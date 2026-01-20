import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> viruses;
    static int[][] grid;
    static int result = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    viruses.add(new int[] {i, j});
                }
            }
        }

        solution(0, 0);

        System.out.println(result);
    }

    public static void solution(int rc, int count) {
//        System.out.println(rc + " " + count);

        if (count == 3) {
            // 몇 개인지 찾는 로직

            Queue<int[]> q = new LinkedList<>(viruses);

            int[][] copy_grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                copy_grid[i] = grid[i].clone();
            }

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = curr[0] + dy[i];
                    int nx = curr[1] + dx[i];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (copy_grid[ny][nx] == 0) {
                            q.add(new int[]{ny, nx});
                            copy_grid[ny][nx] = 2;
                        }
                    }
                }
            }

            int temp = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy_grid[i][j] == 0) {
                        temp++;
                    }
                }
            }

            result = Math.max(result, temp);

            return;
        }

        int r = rc / M;
        int c = rc % M;

        for (int i = r; i < N; i++) {
            for (int j = (i == r ? c : 0); j < M; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    solution(i * M + j + 1, count + 1);
                    grid[i][j] = 0;
                }
            }
        }
    }
}
