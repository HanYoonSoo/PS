import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 퇴사2
     * 오늘부터 N + 1일째 되는 날 퇴사를 한다. 따라서, N일 동안 최대한 많은 상담
     * 1일, 2일, ... 7일 이렇게 형성되어 있고
     * 각 상담은 상담 기간과 얻을 수 있는 금액이 있다.
     *
     * 상담 기간 == T_i, 비용 == P_i
     * 상담기간과 겹치는 일에는 다른 상담은 진행하지 못한다.
     * 또한, N + 1일 째에는 회사에 없기 때문에 그 이후까지 진행되는 상담은 못한다.
     *
     * 이때의 최대 수익
     *
     * 입력 예)
     * 7
     * 3 10
     * 5 20
     * 1 10
     * 1 20
     * 2 15
     * 4 40
     * 2 200
     *
     * 출력 예)
     * 45
     *
     * 위의 예시는 1, 4, 5일 상담하는 것
     *
     * 생각1) 만약, 1일째에서 얻는 이득을 1 + T_i의 DP 값에 더한다면
     *
     * 0 0 0 0 0 0 0
     * 0 0 0 10 0 0 0
     * 10 0 0 10 0 0 20
     * 10 0 0 20 0 0 20
     * 10 0 0 20 40 0 20
     * 10 0 0 20
     *
     * 안됨.
     *
     * 생각2) 뒤에서 부터 계산
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        int[] T = new int[N];
        int[] P = new int[N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;

        int max = 0;

        for(int i = N - 1; i >= 0; i--){
            time = T[i] + i;

            if(time <= N){
                dp[i] = Math.max(P[i] + dp[time], max);
                max = dp[i];
            } else{
                dp[i] = max;
            }
        }

        System.out.println(max);
    }
}
