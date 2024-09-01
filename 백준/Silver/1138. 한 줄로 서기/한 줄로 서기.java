import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //    7
    //    6 1 1 1 2 0 0
    // 6 7
    // 6 7 5
    // 6 4 7 5
    // 6 3 4 7 5
    // 6 2 3 4 7 5 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];

        Arrays.fill(result, -1);

        for(int i = N - 1; i >= 0; i--){
            if(result[arr[i]] != -1){
                int idx = N - 1;
                while(idx != arr[i]){
                    result[idx] = result[idx - 1];
                    idx--;
                }
            }
            result[arr[i]] = i + 1;

//            for(int j = 0; j < N; j++){
//                System.out.print(result[j] + " ");
//            }
//            System.out.println();
        }

        for(int i = 0; i < N; i++){
            System.out.print(result[i] + " ");
        }
    }
}
