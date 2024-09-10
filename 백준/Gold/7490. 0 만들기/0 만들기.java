import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dfs(1, 1, 1, 0, "1");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int depth, int num, int sign, int sum, String result) {
        if (depth == N) {
            sum += num * sign;
            if (sum == 0) {
                sb.append(result).append("\n");
            }
            return;
        }

        // 숫자를 이어붙이는 경우: 공백
        dfs(depth + 1, num * 10 + (depth + 1), sign, sum, result + " " + (depth + 1));

        // + 연산을 하는 경우
        dfs(depth + 1, depth + 1, 1, sum + (num * sign), result + "+" + (depth + 1));

        // - 연산을 하는 경우
        dfs(depth + 1, depth + 1, -1, sum + (num * sign), result + "-" + (depth + 1));
    }
}
