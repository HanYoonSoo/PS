import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");

        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(temp[i]);
            dp[i] += arr[i];
        }

        int max = dp[0];


        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
                max = Math.max(dp[i], max);
            }
        }

        System.out.println(max);
    }
}
