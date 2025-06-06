import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][2];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i][0] = time;
            arr[i][1] = v;
        }

        int[][] dp = new int[N + 1][K + 1];


        int max = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(j >= arr[i][0]){
                    dp[i][j] = Math.max(dp[i - 1][j - arr[i][0]] + arr[i][1], dp[i - 1][j]);
                    max = Math.max(max, dp[i][j]);
                } else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= K; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(max);
    }
}
