import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    // 1  1 1
    // 10 1 2
    // 100 101 2 3
    // 1000 1001 1010  3 4
    // 10000 10001 10100 10101 10010 5 5
    // 100000 100001 101000 101010 101001 100100 100101 100010 8

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N <= 2){
            System.out.println(1);
            System.exit(0);
        }
        
        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1] + dp[i - 2];
        }

        System.out.println(dp[N]);
    }

}
