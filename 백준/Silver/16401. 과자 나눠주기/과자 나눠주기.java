import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        int left = 1;
        int right = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            right = Math.max(arr[i], right);
        }

        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 0;

            for (int i = 0; i < M; i++) {
                count += arr[i] / mid;
            }

            if (count < N) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
