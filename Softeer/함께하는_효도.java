import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] grid;
    static boolean[][] visited;
    static List<int[]> players;
    static int result = 0;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // int total = 0;

        players = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            players.add(new int[]{a, b});
            result += grid[a][b];
            visited[a][b] = true;
        }

        dfs(players.get(0)[0], players.get(0)[1], 0, 0, result);

        System.out.println(result);
    }

    public static void dfs(int y, int x, int idx, int count, int total){
        if(count == 3){
            if(idx + 1 < M){
                dfs(players.get(idx + 1)[0], players.get(idx + 1)[1], idx + 1, 0, total);
            } else if(idx + 1 == M){
                result = Math.max(result, total);
            }

            return;
        }

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny, nx, idx, count + 1, total + grid[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }
}
