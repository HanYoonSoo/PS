import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[N][M][3];
        int[][] arr = new int[N][M];
        int[][] dir = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    dp[i][j][0] = arr[i][j];
                    dp[i][j][1] = arr[i][j];
                    dp[i][j][2] = arr[i][j];

                }
            }
        }

        int[][] d = new int[][]{
                {1, 2},
                {0, 2},
                {0, 1}
        };

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (j + k >= 0 && j + k < M) {
                        int min = Integer.MAX_VALUE;
                        for (int temp : d[k + 1]) {
                            min = Math.min(dp[i - 1][j + k][temp], min);
                        }
                        dp[i][j][k + 1] = min + arr[i][j];
                    } else {
                        dp[i][j][k + 1] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(dp[N - 1][i][j], min);
            }
        }

        System.out.println(min);
    }
}
