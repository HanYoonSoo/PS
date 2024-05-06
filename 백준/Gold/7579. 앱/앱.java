import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 현재 N개의 앱, A1, ..., AN이 활성화 되어 있다고 가정하자.
     * 이들 앱 Ai는 각각 mi 바이트만큼의 메모리를 사용하고 있다.
     * 또한, 앱 Ai를 비활성화한 후에 다시 실행하고자 할 경우, 추가적으로 들어가는 비용(시간 등)을 수치화 한 것을 ci 라고 하자.
     * 이러한 상황에서 사용자가 새로운 앱 B를 실행하고자 하여, 추가로 M 바이트의 메모리가 필요하다고 하자.
     * 즉, 현재 활성화 되어 있는 앱 A1, ..., AN 중에서 몇 개를 비활성화 하여 M 바이트 이상의 메모리를 추가로 확보해야 하는 것이다.
     * 여러분은 그 중에서 비활성화 했을 경우의 비용 ci의 합을 최소화하여 필요한 메모리 M 바이트를 확보하는 방법을 찾아야 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] uses = new int[N ];
        int[] cost = new int[N ];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            uses[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][10001];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= 10000; j++){
                if(i == 0){
                    if(j >= cost[i])
                        dp[i][j] = uses[i];
                } else {
                    if (cost[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + uses[i]);
                    }
                }

                if(dp[i][j] >= M){
                    result = Math.min(result, j);
                }
            }
        }

        System.out.println(result);
    }
}
