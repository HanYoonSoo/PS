import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] reverseArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            reverseArr[N - i - 1] = arr[i];
        }

        int[] increase = new int[N];
        int[] decrease = new int[N];

        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }

                if(reverseArr[j] < reverseArr[i]){
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            max = Math.max(increase[i] + decrease[N - i - 1] - 1, max);
        }

        System.out.println(max);
    }
}
