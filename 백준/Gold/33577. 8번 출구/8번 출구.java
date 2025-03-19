import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] prefixSum = new long[N + 1];

        for(int i = 0; i < N; i++){
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        long[] gain = new long[N + 1];

        for(int i = 1; i <= N; i++){
            gain[i] = arr[i - 1] - prefixSum[i - 1];
        }

        long[] gainMax = new long[N + 1];
        gainMax[1] = gain[1];

        for(int i = 2; i <= N; i++){
            gainMax[i] = Math.max(gainMax[i - 1], gain[i]);
        }

        long curr = 0;
        long count = 0;

        while(curr < prefixSum[N]){
            int idx = Arrays.binarySearch(prefixSum, curr);

            if(idx < 0){
                idx = -idx - 2;
            }

            if(idx == N)
                break;

            long need = prefixSum[idx + 1];
            long gainValue = gainMax[idx + 1];

            long dist = need - curr;

            long c = (gainValue + dist - 1) / gainValue;
            curr += c * gainValue;
            count += c;
        }

        System.out.println(count);
    }
}
