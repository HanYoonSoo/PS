import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int max = 15000;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[31][max + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memoization(0, 0);

        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int ball = Integer.parseInt(st.nextToken());
            if(ball > 15000){
                sb.append("N ");
            } else{
                if(dp[N][ball]){
                    sb.append("Y ");
                } else{
                    sb.append("N ");
                }
            }
        }

        System.out.println(sb);
    }

    public static void memoization(int idx, int weight){
        if(dp[idx][weight]){
            return;
        }
        dp[idx][weight] = true;
        if(idx == N){
            return;
        }


        memoization(idx + 1, weight + arr[idx + 1]);
        memoization(idx + 1, weight);
        memoization(idx + 1, Math.abs(weight - arr[idx + 1]));
    }
}
