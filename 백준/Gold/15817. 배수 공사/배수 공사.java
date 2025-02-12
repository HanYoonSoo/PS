import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] L = new int[N + 1];
        int[] C = new int[N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[X + 1];

        dp[0] = 1;
        
        for(int i = 1; i <= N; i++) {
            for (int j = X; j >= L[i]; j--) {
                for(int k = 1; k <= C[i]; k++){
                    int length = L[i] * k;

                    if(length > j)
                        break;

                    dp[j] += dp[j - length];
                }
            }
        }

        System.out.println(dp[X]);
    }
}

// 4 8 12
// 6 12 18
// 9 18
