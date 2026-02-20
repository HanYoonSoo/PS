import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] grid;
    static int N;
    static int M;
    static int dir;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            if (grid[r][c] == 0) {
                grid[r][c] = 2;
                count++;
            } else if (isNoClean(r, c)) {
                int backDir = backMoveMapping(dir);

                int ny = r + dy[backDir];
                int nx = c + dx[backDir];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (grid[ny][nx] != 1) {
                        r += dy[backDir];
                        c += dx[backDir];
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                dir = (dir + 3) % 4;

                int ny = r + dy[dir];
                int nx = c + dx[dir];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (grid[ny][nx] == 0) {
                        r += dy[dir];
                        c += dx[dir];
                    }
                }
            }

        }

        System.out.println(count);
    }

    public static boolean isNoClean(int r, int c) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (grid[ny][nx] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int backMoveMapping(int dir) {
        if (dir == 0) {
            return 2;
        } else if(dir == 2) {
            return 0;
        } else if(dir == 1) {
            return 3;
        } else {
            return 1;
        }
    }
}
