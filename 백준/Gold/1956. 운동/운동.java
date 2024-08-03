import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] grid = new int[V + 1][V + 1];

        for(int i = 1; i <= V; i++){
            Arrays.fill(grid[i], INF);
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            grid[a][b] = c;
        }

//        int min = Integer.MAX_VALUE;

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        int result = INF;

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(grid[i][j] != INF && grid[j][i] != INF){
                    result = Math.min(result, grid[i][j] + grid[j][i]);
                }
            }
        }

        if(result == INF)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}

//4 5
//1 2 1
//2 3 1
//3 4 1
//4 2 1
//2 1 100

//4 3
//
//        2 3 1
//
//        3 4 1
//
//        4 2 1