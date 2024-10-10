import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int N;
    static boolean[][] light;
    static boolean[][] visited;
    static Map<Point, List<Point>> pointMap = new HashMap<>();
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        light = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Point start = new Point(x, y);
            Point target = new Point(a, b);

            pointMap.computeIfAbsent(start, k -> new ArrayList<>()).add(target);
        }

        bfs();

        System.out.println(result);
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1, 1));
        light[1][1] = true;
        visited[1][1] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            // 불을 켤 수 있는 방이 있다면 전부 켬
            if (pointMap.containsKey(curr)) {
                visited = new boolean[N + 1][N + 1];
                visited[curr.x][curr.y] = true;
                for (Point point : pointMap.get(curr)) {
                    if (!light[point.x][point.y]) {
                        light[point.x][point.y] = true;
                        result++;
                    }
                }
                pointMap.remove(curr); // 이미 불을 켠 곳은 리스트에서 제거
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;

                // 불이 켜져 있고 아직 방문하지 않은 곳
                if (light[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }

            // 불이 켜져 있는 곳에서 다시 탐색 가능
        }
    }
}
//4 10
//1 1 1 2
//1 2 1 3
//1 2 4 1
//1 3 1 4
//1 3 3 1
//1 4 2 4
//1 4 2 1
//2 1 4 4
//3 1 4 3
//4 1 3 4