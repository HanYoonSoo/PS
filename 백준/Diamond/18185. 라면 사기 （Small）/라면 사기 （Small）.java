import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        for(int i = 0; i < N; i++){
            while(arr[i] > 0 && arr[i + 1] > 0 && arr[i + 1] > arr[i + 2]){
                arr[i] -= 1;
                arr[i + 1] -= 1;
                total += 5;
            }

            int min = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));

            total += (min * 7);
            arr[i] -= min;
            arr[i + 1] -= min;
            arr[i + 2] -= min;

            total += arr[i] * 3;
            arr[i] = 0;
        }

        System.out.println(total);
    }
}
