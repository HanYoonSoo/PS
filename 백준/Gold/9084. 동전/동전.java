import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 동전
     * 입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다.
     * 각 테스트 케이스의 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고 두 번째 줄에는 N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다.
     * 각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다.
     * 세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.
     *
     * 입력 예)
     * 3
     * 2
     * 1 2
     * 1000
     * 3
     * 1 5 10
     * 100
     * 2
     * 5 7
     * 22
     *
     * 출력 예)
     * 501
     * 121
     * 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] coin = new int[N];
            int[] dp = new int[10001];

            Arrays.fill(dp, 0);

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = 1;

            int target = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++){
                for(int j = 0; j <= target; j++){
                    if(j >= coin[i]){
                        dp[j] += dp[j - coin[i]];
                    }
                }
            }

            System.out.println(dp[target]);
        }

    }
}
