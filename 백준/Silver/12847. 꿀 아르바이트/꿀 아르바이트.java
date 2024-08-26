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

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;

        for(int i = 0; i < K; i++){
            sum += arr[i];
        }

        long window = sum;
        long max = sum;

        for(int i = 0; i + K < N; i++){
            window -= arr[i];
            window += arr[i + K];
            
            if(window > max){
                max = window;
            }
        }

        System.out.println(max);
    }
}
