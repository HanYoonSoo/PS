import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] fall = new int[T + 1];

        for(int i = 1; i <= T; i++){
            fall[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];

        for (int i = 1; i <= T; i++) {
            for (int j = 0; j <= W; j++) {
                if(j == 0){
                    if(fall[i] == 1){
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                } else {
                    if (fall[i] == 1 && j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    } else if (fall[i] == 2 && j % 2 == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }

        int max = 0;

        for(int i = 0; i <= W; i++){
            max = Math.max(dp[T][i], max);
        }

        System.out.println(max);
    }
}
//8 1
//2
//2
//2
//2
//1
//2
//1
//2
