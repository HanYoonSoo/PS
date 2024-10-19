import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        List<Integer>[] students = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            students[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                students[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[N + 1][H + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= H; j++){
                for(int block : students[i]){
                    if(j == block){
                        dp[i][j]++;
                    }
                    if(j > block){
                        dp[i][j] += dp[i - 1][j - block];
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[N][H]);
    }
}
