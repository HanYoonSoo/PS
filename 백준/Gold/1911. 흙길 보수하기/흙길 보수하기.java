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
        int L = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        int count = (int)Math.ceil((double)(arr[0][1] - arr[0][0]) / L);

        int end = arr[0][0] + count * L;

        for(int i = 1; i < N; i++){
            if(end >= arr[i][0]){
                int compute = (int)Math.ceil((double)(arr[i][1] - end) / L);
                count += compute;
                end = end + compute * L;
            } else{
                int compute = (int)Math.ceil((double)(arr[i][1] - arr[i][0]) / L);
                count += compute;
                end = arr[i][0] + compute * L;
            }
        }


        System.out.println(count);
    }
}

//3 10
//1 6
//7 8
//11 15