import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String compare(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b) > 0 ? a : b;
        }
        return a.length() < b.length() ? b : a;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];
        String[][] dp = new String[51][51];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        // dp 초기화
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(dp[i], "");
        }

        for (int i = 0; i < N; i++) {
            if (P[i] > M) continue;
            dp[P[i]][1] = compare(dp[P[i]][1], Integer.toString(i));
        }

        for (int i = 2; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (j > M) continue;

                for (int k = 1; k < j; k++) {
                    if (dp[k][i - 1].isEmpty() || dp[k][i - 1].charAt(0) == '0') continue;

                    for (int h = 1; h <= j - k; h++) {
                        dp[j][i] = compare(dp[j][i], dp[k][i - 1] + dp[h][1]);
                    }
                }
            }
        }

        String answer = "";
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                answer = compare(answer, dp[j][i]);
            }
        }

        System.out.println(answer);
    }
}
