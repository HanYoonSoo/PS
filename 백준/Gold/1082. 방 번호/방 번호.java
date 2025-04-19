import java.util.*;

public class Main {
    static int N;
    static List<Integer> v = new ArrayList<>();
    static int M;
    static String[][] dp = new String[51][51];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            v.add(sc.nextInt());
        }

        M = sc.nextInt();

        // dp 초기화
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(dp[i], "");
        }

        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) > M) continue;
            dp[v.get(i)][1] = compare(dp[v.get(i)][1], Integer.toString(i));
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

    // 길이 비교 후 문자열 비교
    static String compare(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b) > 0 ? a : b;
        }
        return a.length() < b.length() ? b : a;
    }
}
