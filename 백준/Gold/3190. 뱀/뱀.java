import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int L;
    static int[][] grid;
    static Map<Integer, String> transformMap = new HashMap<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int dir = 1;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        grid[0][0] = 2;
        q.add(new int[]{0, 0});

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            grid[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            transformMap.put(time, command);
        }

        int time = 0;
        int r = 0;
        int c = 0;

        while (true) {
//            System.out.println("dir: " + dir);
            time++;
            int ny = r + dy[dir];
            int nx = c + dx[dir];
//            System.out.println(ny + " " + nx);

            if (0 <= ny && ny < N && 0 <= nx && nx < N && grid[ny][nx] != 2) {
                if (grid[ny][nx] == 1) {
                    grid[ny][nx] = 2;
                } else {
                    if (!q.isEmpty()) {
                        int[] temp = q.poll();
                        grid[temp[0]][temp[1]] = 0;
                        grid[ny][nx] = 2;
                    }
                }
                r = ny;
                c = nx;
                q.add(new int[]{ny, nx});
            } else {
                break;
            }

            if (transformMap.containsKey(time)) {
                String command = transformMap.get(time);

                if (command.equals("L")) {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

//            System.out.println("time: " + time);
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(grid[i][j] + " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("===============================");
        }

        System.out.println(time);
    }
}
