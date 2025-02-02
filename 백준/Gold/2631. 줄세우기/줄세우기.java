import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] child = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            child[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(child[i] > child[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }

        System.out.println(N - max);
    }
}
