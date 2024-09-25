import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int idx, int count){
        if(count == N / 2){
            int teamStart = 0;
            int teamLink = 0;

            for(int i = 0; i < N - 1; i++){
                for(int j = i + 1; j < N; j++){
                    if(visited[i] && visited[j]){
                        teamStart += grid[i][j] + grid[j][i];
                    }

                    if(!visited[i] && !visited[j]){
                        teamLink += grid[i][j] + grid[j][i];
                    }
                }
            }

            int diff = Math.abs(teamStart - teamLink);

            if(diff == 0){
                System.out.println(0);
                System.exit(0);
            } else{
                result = Math.min(result, diff);
            }

            return;
        }

        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
