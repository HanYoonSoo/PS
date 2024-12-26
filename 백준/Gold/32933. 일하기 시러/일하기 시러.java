import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[M + 1];

        int max = 0;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int j = a; j < M + 1; j++){
                for(int k = 0; k < M; k++){
                    if(j + b * k > M)
                        break;
                    dp[j + b * k] = Math.max(dp[j + b * k], dp[j - a] + c + c * k);

                    max = Math.max(max, dp[j + b * k]);
                }
            }
        }

        System.out.println(max * N);
    }
}
