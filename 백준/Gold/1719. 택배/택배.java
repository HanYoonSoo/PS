import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 입력)
     * 6 10
     * 1 2 2
     * 1 3 1
     * 2 4 5
     * 2 5 3
     * 2 6 7
     * 3 4 4
     * 3 5 6
     * 3 6 7
     * 4 6 4
     * 5 6 2
     */
    static int N;
    static int M;
    static int[][] grid;
    static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++)
            Arrays.fill(grid[i], Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            grid[to][from] = grid[from][to] = Math.min(grid[from][to], weight);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                path[i][j] = j;
            }
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(grid[i][k] == Integer.MAX_VALUE || grid[k][j] == Integer.MAX_VALUE)
                        continue;

                    if(grid[i][j] > grid[i][k] + grid[k][j]){
                        grid[i][j] = grid[i][k] + grid[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j)
                    System.out.print("- ");
                else
                    System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
