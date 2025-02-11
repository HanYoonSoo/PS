import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] L = new int[P + 1];
        int[] C = new int[P + 1];

        for(int i = 1; i <= P; i++){
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[D + 1];

        dp[0] = Integer.MAX_VALUE;
        
        for(int i = 1; i <= P; i++){
            for(int j = D; j >= L[i]; j--){
                dp[j] = Math.max(dp[j], Math.min(dp[j - L[i]], C[i]));
            }
        }

        System.out.println(dp[D]);
    }
}
