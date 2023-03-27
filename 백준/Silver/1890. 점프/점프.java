import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] grid;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dp[0][0] = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int dist = grid[i][j];

                if(dist == 0){
                    break;
                }
                
                if((j + dist) < N){
                    dp[i][j + dist] += dp[i][j];
                }
                if((i + dist) < N){
                    dp[i + dist][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
