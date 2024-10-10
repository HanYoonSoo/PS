import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point{
        int y;
        int x;

        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj){
            Point point = (Point) obj;

            return this.y == point.y && this.x == point.x;
        }
    }

    static int N, K, R;
    static List<Point>[][] grid;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new ArrayList[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                grid[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            int aY = Integer.parseInt(st.nextToken());
            int aX = Integer.parseInt(st.nextToken());

            int bY = Integer.parseInt(st.nextToken());
            int bX = Integer.parseInt(st.nextToken());

            grid[aY][aX].add(new Point(bY, bX));
            grid[bY][bX].add(new Point(aY, aX));
        }

        int[][] map = new int[N + 1][N + 1];

        List<Point> points = new ArrayList<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
            points.add(new Point(y, x));
        }

        int result = 0;

        for(int i = 0; i < K; i++){
            boolean[][] visited = new boolean[N + 1][N + 1];
            boolean[][] meetCow = new boolean[K][K];

            Point point = points.get(i);
            visited[point.y][point.x] = true;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{point.y, point.x});

            while(!q.isEmpty()){
                int[] curr = q.poll();

                if(map[curr[0]][curr[1]] == 1){
                    for(int j = i + 1; j < K; j++){
                        if(points.get(j).y == curr[0] && points.get(j).x == curr[1]){
                            meetCow[i][j] = true;
                            break;
                        }
                    }
                }

                for(int j = 0; j < 4; j++){
                    int ny = curr[0] + dy[j];
                    int nx = curr[1] + dx[j];

                    if(1 <= ny && ny <= N && 1 <= nx && nx <= N && !visited[ny][nx]){
                        if(!grid[curr[0]][curr[1]].contains(new Point(ny, nx))){
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                        }
                    }
                }
            }

            for(int j = i + 1; j < K; j++){
                if(!meetCow[i][j]){
//                    System.out.println(i + " " + j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
