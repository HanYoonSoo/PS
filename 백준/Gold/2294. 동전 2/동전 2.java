import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];

        Arrays.fill(dp, 987654321);

        for(int i = 0; i < N; i++){
            if(K >= coin[i]){
                dp[coin[i]] = 1;
                for(int j = 0; j <= K; j++){
                    if(j >= coin[i])
                        dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
                }
            }
        }

        System.out.println(dp[K] > 10000 ? -1 : dp[K]);
    }
}
