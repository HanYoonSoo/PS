import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int INF = 1000 * 1000;
    static int N;

    static int arr[][];

    static int dp[][];
    static int result = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];
        dp = new int[N + 1][3];

        for(int i = 1 ; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < 3; k++) {
            for(int i = 0 ; i < 3; i++) {
                if(i == k) dp[1][i] = arr[1][i];
                else dp[1][i] = INF;
            }


            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }

            for(int i = 0 ; i < 3; i++)
                if(i != k) result = Math.min(result, dp[N][i]);
        }

        System.out.println(result);
    }
}