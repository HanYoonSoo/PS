import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int INF = 987654321;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, INF);

        dp[1] = 0;
        for(int i = 1; i <= N; i++){
            if(dp[i] == 0 && i != 1){
                continue;
            }
            for(int j = 1; j <= arr[i]; j++){
                if(j + i <= N){
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[N] >= INF ? -1 : dp[N]);
    }
}
