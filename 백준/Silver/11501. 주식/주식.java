import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] reverseArr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 0;

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i], max);
            }

            max = arr[N - 1];
            reverseArr[N - 1] = max;

            for(int i = N - 2; i >= 0; i--){
                if(arr[i] > max){
                    max = arr[i];
                    reverseArr[i] = max;
                } else{
                    reverseArr[i] = max;
                }
            }

//            for(int i = 0; i < N; i++){
//                System.out.print(reverseArr[i] + " ");
//            }

            long sum = 0;
            int count = 0;
            long result = 0;

//            Arrays.sort(reverseArr);

            int idx = N - 1;

            for(int i = 0; i < N; i++){
                if(arr[i] != reverseArr[i]){
                    result += (reverseArr[i] - arr[i]);
                }
            }

            System.out.println(result);
        }
    }
}

// 9
// 7
// 6