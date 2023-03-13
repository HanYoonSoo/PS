import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] child;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        child = new int[N + 1];

        for(int i = 1; i <= N; i++){
            child[i] = Integer.parseInt(br.readLine());
        }

        int[] location = new int[N + 1];

        for(int i = 1; i <= N; i++){
            location[child[i]] = i;
        }

//        for(int num : location){
//            System.out.println(num);
//        }

        int maxNum = -1;

        int dp[] = new int[N + 1];

        Arrays.fill(dp, 1);

        for(int i = 1; i <= N; i++){
            for(int j = 1; j < i; j++){
                if(location[i] > location[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxNum = Math.max(maxNum, dp[i]);
        }

        System.out.println(N - maxNum);
    }
}
