import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] days = new int[N + 1];
        int[] cost = new int[N + 1];

        int totalCost = 0;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            days[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }

        int[] dp = new int[T + 1];

        for(int i = 1; i <= N; i++){
            for(int j = T; j >= days[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - days[i]] + cost[i]);
            }
        }

        System.out.println(totalCost - dp[T]);
    }
}
