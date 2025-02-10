import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while ((st = new StringTokenizer(br.readLine())) != null) {
            int N = Integer.parseInt(st.nextToken());
            int M = (int)(Float.parseFloat(st.nextToken()) * 100 + 0.5);

            if (N == 0) {
                break;
            }

            int[] c = new int[N + 1];
            int[] p = new int[N + 1];

            int[] dp = new int[M + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                c[i] = Integer.parseInt(st.nextToken());
                p[i] = (int)(Float.parseFloat(st.nextToken()) * 100 + 0.5);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = p[i]; j <= M; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p[i]] + c[i]);
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
    }
}
