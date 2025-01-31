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
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N + 1];
        int[] c = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            m[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st2.nextToken());
        }

        int[][] dp = new int[N + 1][10001];

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= 10000; j++){
                if(j < c[i]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - c[i]] + m[i], dp[i - 1][j]);
                }

                if(dp[i][j] >= M){
                    min = Math.min(min, j);
                }
            }
        }

        System.out.println(min);
    }
}
