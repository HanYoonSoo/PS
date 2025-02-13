import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++){
            int N = Integer.parseInt(br.readLine());

            int sum = 0;

            int[] coin = new int[N + 1];
            int[] count = new int[N + 1];

            for(int j = 1; j <= N; j++){
                st = new StringTokenizer(br.readLine());

                coin[j] = Integer.parseInt(st.nextToken());
                count[j] = Integer.parseInt(st.nextToken());

                sum += coin[j] * count[j];
            }

            if(sum % 2 == 1){
                sb.append(0).append("\n");
                continue;
            }

            int[] dp = new int[sum + 1];

            dp[0] = 1;

            for(int j = 1; j <= N; j++){
                for(int k = sum; k >= 0; k--){
                    if(dp[k] > 0){ // 이전 상태가 가능한 경우만
                        for(int l = 1; l <= count[j] && k + coin[j] * l <= sum; l++){
                            dp[k + coin[j] * l] += dp[k];
                        }
                    }
                }
            }


//            for(int j = 1; j <= sum; j++){
//                System.out.println(j + " " + dp[j]);
//            }
//            System.out.println("===================");

            if(dp[sum / 2] != 0)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
