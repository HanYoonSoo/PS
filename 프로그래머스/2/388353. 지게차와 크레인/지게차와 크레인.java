import java.util.*;

class Solution {
    char[][] grid;
    int N, M;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();

        grid = new char[N][M];

        int count = N * M;

        for (int i = 0; i < N; i++) {
            grid[i] = storage[i].toCharArray();
        }

        for (String request : requests) {
            char target = request.charAt(0);
            Queue<int[]> queue = new LinkedList<>();
            List<int[]> list = new ArrayList<>();

            if (request.length() == 1) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (grid[i][j] == target && isSide(i, j)) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (grid[i][j] == target) {
                            queue.add(new int[]{i, j});
                        }
                    }
                }
            }

            for (int[] arr : list) {
                grid[arr[0]][arr[1]] = '0';
                count--;
            }

            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                grid[arr[0]][arr[1]] = '0';
                count--;
            }
        }

        return count;
    }

    public boolean isSide(int y, int x) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    return true;
                }

                if (!visited[ny][nx] && grid[ny][nx] == '0') {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return false;
    }
}
