import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int INF = 100001;
        int[] dp = new int[100001];

        int num = 1;

        while(num * num <= 100000){
            num++;
        }

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for(int i = 1; i <= num; i++){
            for(int j = i; j <= 100000; j++){
                if(j >= i * i) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        int N = Integer.parseInt(br.readLine());

        System.out.println(dp[N]);
    }
}
