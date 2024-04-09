import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 포도주 시식 규칙
     * 1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 함. (마신 후에는 원래 위치)
     * 2. 연속으로 놓여 있는 3잔을 마실 순 없음.
     * 되도록 많은 포도주를 맛 보는 것이 목적
     *
     * 입력 예)
     * 6
     * 6
     * 10
     * 13
     * 9
     * 8
     * 1
     *
     * 출력 예)
     * 33
     *
     * 위의 예시에서는 1, 2, 4, 5 포도주를 마시면 최대
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[10001];

        int[] dp = new int[10001];

        for(int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(num[1]);
            return;
        } else if(N == 2){
            
        }
        dp[1] = num[1];
        dp[2] = num[1] + num[2];


        for(int i = 3; i <= N; i++){
            int max = Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i - 1] + num[i]);
            dp[i] = Math.max(max, dp[i - 1]);
        }

        int max = 0;

        for(int i = 1; i <= N; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
