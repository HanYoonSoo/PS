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

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < N; i++){
            int left = 0;
            int right = N - 1;

            while(left < right){
                if(left == i){
                    left++;
                } else if(right == i){
                    right--;
                } else {
                    int sum = arr[left] + arr[right];
                    if(sum < arr[i]){
                        left++;
                    } else if(sum > arr[i]){
                        right--;
                    } else {
//                        System.out.println(sum + " " + arr[i]);
                        count++;
                        break;
                    }
                }

//                System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
            }
        }

        System.out.println(count);
    }
}
