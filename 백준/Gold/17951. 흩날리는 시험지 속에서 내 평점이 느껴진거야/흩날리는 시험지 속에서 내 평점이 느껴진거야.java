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

        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }

        int left = min;
        int right = 20 * 100000;

        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            int group = 0;
            for(int i = 0; i < N; i++){
                sum += arr[i];

                if(sum >= mid){
                    sum = 0;
                    group++;
                }
            }

            if(K > group){
                right = mid - 1;
            } else{
                left = mid + 1;
            }

//            System.out.println(left + " " + right);
        }

        System.out.println(left - 1);
    }
}
