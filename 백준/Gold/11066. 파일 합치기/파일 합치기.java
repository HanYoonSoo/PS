import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        while(T-- > 0){

            int N = Integer.parseInt(br.readLine());

            int[] file = new int[N + 1];
            int[][] dp = new int[N + 1][N + 1];
            int[] sum = new int[N + 1];

            String[] temp = br.readLine().split(" ");

            for(int i = 1; i <= N; i++){
                file[i] = Integer.parseInt(temp[i-1]);
                sum[i] = sum[i-1] + file[i];
            }

            for(int diag = 1; diag <= N; diag++){
                for(int i = 1; i + diag <= N; i++){
                    int j = diag + i;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i-1]);
                    }
                }
            }

            System.out.println(dp[1][N]);
        }
    }
}
