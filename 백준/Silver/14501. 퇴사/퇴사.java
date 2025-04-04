import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int maxValue = 0;

        for (int i = N - 1; i >= 0; i--) {
            int time = i + T[i];

            if (time <= N) {
                dp[i] = Math.max(P[i] + dp[time], maxValue);
                maxValue = dp[i];
            } else {
                dp[i] = maxValue;
            }
        }

        System.out.println(maxValue);
    }
}
