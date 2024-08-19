import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                int target = Integer.parseInt(st.nextToken());

                int left = 0;
                int right = N - 1;

                boolean result = false;
                while(left <= right){
                    int mid = (left + right) / 2;

                    if(arr[mid] > target){
                        right = mid - 1;
                    } else if(arr[mid] < target){
                        left = mid + 1;
                    } else{
                        result = true;
                        break;
                    }
                }

                bw.write(result ? "1" : "0");
                bw.write("\n");
            }

            bw.flush();

        }
    }
}
