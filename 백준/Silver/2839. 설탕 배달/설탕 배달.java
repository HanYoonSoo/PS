import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dp = new int[5001];

        Arrays.fill(dp, 987654321);

        dp[3] = 1;
        dp[5] = 1;

        for(int i = 6; i < 5001; i++){
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dp[N] > 5000 ? -1 : dp[N]);
    }
}
