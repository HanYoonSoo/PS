import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = 1;

        int min = Integer.MAX_VALUE;
        while(p1 < N && p2 < N){
            int compute = Math.abs(arr[p1] - arr[p2]);

            if(compute >= M){
                p1++;
                if(min > compute){
                    min = compute;
                }
            } else{
                p2++;
            }
            
        }

        System.out.println(min);
    }
}
//4 3
//10 2 10 8

//7 4
//1
//8
//15
//16
//17
//18
//22
//7