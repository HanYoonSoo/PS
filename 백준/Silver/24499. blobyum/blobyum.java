import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for(int i = 0; i < K; i++){
            sum += arr[i];
        }

        int window = sum;
        int max = sum;

        for(int i = K; i < N + K; i++){
            window += arr[i % N] - arr[(i - K) % N];
            if(window > max){
                max = window;
            }
        }

        System.out.println(max);
    }
}
