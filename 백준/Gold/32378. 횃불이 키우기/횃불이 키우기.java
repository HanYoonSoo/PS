import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력 받기: N, K, S
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N: 일 수
        int K = Integer.parseInt(st.nextToken()); // K: 곱하는 최대 횟수
        int S = Integer.parseInt(st.nextToken()); // S: 초기 크기

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // K가 36보다 크면 바로 "MEGA" 출력
        if (K > 36) {
            System.out.println("MEGA");
            return;
        }

        // DP 테이블 초기화
        long[][] dp = new long[N + 1][K + 1];
        dp[0][0] = S;

        // DP 테이블 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                // 현재 상태에서 진행할 수 없는 경우 스킵
                if (dp[i][j] <= 0) continue;

                // 성장하는 경우
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + arr[i]);

                // 곱하는 경우
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] * 2);
            }

            // 마지막 곱셈 가능한 상태에서 성장
            if (dp[i][K] > 0) {
                dp[i + 1][K] = Math.max(dp[i + 1][K], dp[i][K] + arr[i]);
            }
        }

        // 최종 최대 크기 찾기
        long max = 0;
        for (int i = 0; i <= K; i++) {
            max = Math.max(max, dp[N][i]);
        }

        // 출력 조건에 따른 결과 출력
        if (max > 100000000000L) {
            System.out.println("MEGA");
        } else if (max <= 0) {
            System.out.println("-1");
        } else {
            System.out.println(max);
        }
    }
}
