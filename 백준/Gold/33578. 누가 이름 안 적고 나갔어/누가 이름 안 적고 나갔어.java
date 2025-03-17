import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static char[][] grid;
    static int[][] distSeungchan, distJinwoo;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];

        int seungchanY = -1, seungchanX = -1;
        int jinwooY = -1, jinwooX = -1;
        List<int[]> teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'S') {
                    seungchanY = i;
                    seungchanX = j;
                } else if (grid[i][j] == 'J') {
                    jinwooY = i;
                    jinwooX = j;
                } else if (grid[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                }
            }
        }

        // BFS 실행하여 최단 거리 계산
        distSeungchan = bfs(seungchanY, seungchanX);
        distJinwoo = bfs(jinwooY, jinwooX);

        // 최소 거리 계산
        int result = INF;

        // 1. 진우 -> 승찬 직접 가는 경우
        if (distJinwoo[seungchanY][seungchanX] != INF) {
            result = distJinwoo[seungchanY][seungchanX] * 2;
        }

        // 2. 선생님을 경유하는 경우
        for (int[] teacher : teachers) {
            int ty = teacher[0], tx = teacher[1];
            if (distSeungchan[ty][tx] != INF && distJinwoo[ty][tx] != INF) {
                result = Math.min(result, distSeungchan[ty][tx] + distJinwoo[ty][tx] * 2);
            }
        }

        System.out.println(result == INF ? -1 : result);
    }

    private static int[][] bfs(int startY, int startX) {
        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, INF);
        Queue<int[]> queue = new LinkedList<>();

        dist[startY][startX] = 0;
        queue.add(new int[]{startY, startX});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0], x = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && grid[ny][nx] != '#') {
                    if (dist[ny][nx] == INF) {
                        dist[ny][nx] = dist[y][x] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return dist;
    }
}
