import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int edges = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < edges; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            int result = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && graph[i][j] == 1){
                        bfs(i, j);
                        result++;
//                        System.out.println(i + " " + j);
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void bfs(int a, int b) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{a, b});
        visited[a][b] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int y = curr[0];
            int x = curr[1];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && graph[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
