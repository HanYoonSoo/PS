import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int[] coin = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];

            dp[0] = 1;

//            for(int i = 0; i < N; i++){
//                dp[coin[i]] = 1;
//            }

            for(int i = 0; i < N; i++){
                for(int j = 1; j <= M; j++){
                    if(j >= coin[i]){
                        dp[j] += dp[j - coin[i]];
                    }
                }
            }

            System.out.println(dp[M]);

//            for(int i = 1; i <= M; i++){
//                System.out.print(i + ": " + dp[i] + " ");
//            }
//
//            System.out.println();
        }
    }
}

// 1 2          3
// 1 1 1        1 1 1
//   2          1 2