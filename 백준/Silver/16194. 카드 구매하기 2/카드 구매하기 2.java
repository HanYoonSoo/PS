import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        int[] C = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            P[i] = Integer.parseInt(st.nextToken());
            C[i] = i;
        }

        int[] dp = new int[N + 1];

        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i = 1; i <= N; i++){
            for(int j = C[i]; j <= N; j++){
                dp[j] = Math.min(dp[j], dp[j - C[i]] + P[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
