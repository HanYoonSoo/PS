import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int N;
    static int K;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }


        visited[K] = true;
        dfs(K,0);

        System.out.println(result);
    }

    public static void dfs(int idx, int sum){
        boolean compare = false;

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                compare = true;
                visited[i] = true;
                dfs(i, sum + grid[idx][i]);
                visited[i] = false;
            }
        }

        if(!compare){
            result = Math.min(result, sum);
        }
    }
}
