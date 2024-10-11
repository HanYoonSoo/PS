import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] points = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i][0] = x;
            points[i][1] = y;
        }

        int[][] dp = new int[K + 1][N];
        int sum = 0;

        for(int i = 0; i <= K; i++){
            Arrays.fill(dp[i], -1);
//            sum += Math.abs(points[i - 1][0] - points[i][0]) + Math.abs(points[i - 1][1] - points[i][1]);
//            dp[i][0] = sum;
            if(i == 0){
                dp[i][0] = 0;
            }
        }

        int min;
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= K; j++){
                if(i - j > 0){
                    min = Integer.MAX_VALUE;

                    for(int k = 0; k <= j; k++){
                        if(dp[j - k][i - k - 1] != -1){
                            int compute = Math.abs(points[i - k - 1][0] - points[i][0]) + Math.abs(points[i - k - 1][1] - points[i][1]);
                            min = Math.min(dp[j - k][i - k - 1] + compute, min);
                        }
                    }
                    dp[j][i] = min;
                }
            }
        }

        int result = dp[0][N - 1];
        for(int i = 1; i <= K; i++) {
            result = Math.min(result, dp[i][N - 1]);
        }
        System.out.println(result);
    }
}
