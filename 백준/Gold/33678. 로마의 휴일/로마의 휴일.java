import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, X;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(isPossible(mid)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println((left - 1) == 0 ? -1 : (left - 1));
    }

    public static boolean isPossible(int d) {
        int money;

        for(int i = 1; i + d - 1 <= N; i++){
            money = prefixSum[i - 1] * X + prefixSum[N] - prefixSum[i + d - 1];

            if(money >= K){
                return true;
            }
        }

        return false;
    }
}
