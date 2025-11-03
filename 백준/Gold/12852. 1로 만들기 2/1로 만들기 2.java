import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int[] dp = new int[target * 3 + 1];
        int[] prev = new int[target * 3 + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i = 1; i < target; i++) {
            if(i + 1 <= target && dp[i + 1] > dp[i] + 1) {
                dp[i + 1] = dp[i] + 1;
                prev[i + 1] = i;
            }

            if(i * 2 <= target && dp[i * 2] > dp[i] + 1) {
                dp[i * 2] = dp[i] + 1;
                prev[i * 2] = i;
            }

            if(i * 3 <= target && dp[i * 3] > dp[i] + 1) {
                dp[i * 3] = dp[i] + 1;
                prev[i * 3] = i;
            }
        }

        System.out.println(dp[target]);
        for(int curr = target; curr != 0; curr = prev[curr]) {
            System.out.print(curr + " ");
        }
    }
}
