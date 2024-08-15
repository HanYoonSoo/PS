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

        int p1 = 0;
        int p2 = N - 1;

        int min = Integer.MAX_VALUE;

        int result1 = 0;
        int result2 = 0;

        while(p1 < p2){
            int check = -(arr[p1] + arr[p2]);
            if(min > Math.abs(check)){
                min = Math.abs(check);

                result1 = arr[p1];
                result2 = arr[p2];
            }

            if(arr[p1] + arr[p2] > 0){
                p2--;
            } else if(arr[p1] + arr[p2] < 0){
                p1++;
            } else{
                System.out.println(result1 + " " + result2);
                System.exit(0);
            }
        }

        System.out.println(result1 + " " + result2);
    }
}
