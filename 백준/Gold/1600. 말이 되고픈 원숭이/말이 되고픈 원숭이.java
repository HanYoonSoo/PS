import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 입력)
     * 1
     * 4 4
     * 0 0 0 0
     * 1 0 0 0
     * 0 0 1 0
     * 0 1 0 0
     *
     * 출력)
     * 4
     */
    static int N;
    static int M;
    static int K;
    static int[][] grid;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] hx = {{0, -1}, {0, 1}, {-1, -1}, {1, 1}, {-1, -1}, {1, 1}, {0, -1}, {0, 1}};
    static int[][] hy = {{-1, -1}, {-1, -1}, {0, -1}, {0, -1}, {0, 1}, {0, 1}, {1, 1}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());


        grid = new int[N][M];
        visited = new boolean[N][M][31];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1 && M == 1){
            if(grid[0][0] == 0)
                System.out.println(0);
            else
                System.out.println(-1);
            return;
        }

        int result = bfs();

        System.out.println(result);
    }

    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int hc = curr[2];
            int count = curr[3];

//            System.out.println(y + " " + x + " " + hc + " count: " + count);
            // 인접 이동
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && grid[ny][nx] != 1 && !visited[ny][nx][hc]){
                    if(ny == N - 1 && nx == M - 1){
                        return count + 1;
                    }
                    visited[ny][nx][hc] = true;
                    q.add(new int[]{ny, nx, hc, count + 1});
                }
            }

            if(hc < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = y;
                    int nx = x;
                    for (int j = 0; j < 2; j++) {
                        ny = ny + hy[i][j];
                        nx = nx + hx[i][j];

//                        if (0 <= ny && ny < N && 0 <= nx && nx < M && grid[ny][nx] != 1) {
//                            continue;
//                        } else {
//                            break;
//                        }
                    }
                    if (0 <= ny && ny < N && 0 <= nx && nx < M && grid[ny][nx] != 1 && !visited[ny][nx][hc + 1]) {
                        visited[ny][nx][hc + 1] = true;
                        if(ny == N - 1 && nx == M - 1){
//                            System.out.println(ny + " " + nx + " " + count);
                            return count + 1;
                        }
                        q.add(new int[]{ny, nx, hc + 1, count + 1});
                    }
                }
            }
        }

        return -1;
    }
}

//0 0 1 0 0 1 0 0 1 0
//0 0 1 1 0 0 0 0 1 0