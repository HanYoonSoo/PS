import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N];
        int[] J = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];

        for(int i = 0; i < N; i++){
            for(int j = 99; j >= L[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - L[i]] + J[i]);
            }
        }

        System.out.println(dp[99]);
    }
}
