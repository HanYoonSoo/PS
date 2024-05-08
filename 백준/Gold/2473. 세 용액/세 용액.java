import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long max = 3000000000L;

        long[] solution = new long[3];

        for(int i = 0; i < N - 2; i++){
            int left = i + 1;
            int right = N - 1;

            while(left < right){
                long compare = arr[i] + arr[left] + arr[right];

                if(max > Math.abs(compare)){
                    solution[0] = arr[i];
                    solution[1] = arr[left];
                    solution[2] = arr[right];
                    max = Math.abs(compare);
                }

                if(compare > 0){
                    right--;
                } else if(compare < 0){
                    left++;
                } else{
                    break;
                }
            }
        }

        Arrays.sort(solution);

        for(int i = 0; i < 3; i++){
            System.out.print(solution[i] + " ");
        }
    }
}
