import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while(left <= right){
            int mid = (left + right) / 2;

            int count = 0;
            int sum = 0;

            for(int i = 0; i < N; i++){
                if(sum + arr[i] > mid){
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            count += 1;

            if(count <= M){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            sum += arr[i];
            if(sum > left){
                M--;
                sum = arr[i];
                sb.append(count).append(" ");
                count = 1;
            } else {
                count++;
            }
            
            if(M == N - i)
                break;
        }

        while(M-- > 0){
            sb.append(count).append(" ");
            count = 1;
        }

        System.out.println(sb);
    }
}
//5 4 2 6 9 3 8 7
