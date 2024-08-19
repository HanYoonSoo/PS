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

        int[] arr = new int[N];

        int max = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());

            max = Math.max(arr[i], max);
        }

//        if(max == 0){
//            System.out.println(0);
//            return;
//        }

        long left = 1;
        long right = max;

        while(left <= right){
            long mid = (left + right) / 2;

            int count = 0;
            for(int i = 0; i < N; i++){
                count += arr[i] / mid;
            }

            if(count < K){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
//            System.out.println(mid);
        }

        System.out.println(left - 1);
    }
}
