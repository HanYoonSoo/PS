import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            long result = 0;

            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    result += GCD(arr[j], arr[k]);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
