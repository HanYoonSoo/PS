import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];

        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr[M] = L;

        int[] cuts = new int[N];

        for(int i = 0; i < N; i++){
            cuts[i] = Integer.parseInt(br.readLine());
        }

        for(int cut : cuts){
            int left = 1;
            int right = L;

            int result = 0;

            while(left <= right){
                int mid = (left + right) / 2;

                int cutCount = 0;

                int cutValue = 0;
                for(int i = 0; i <= M; i++){
                    if((arr[i] - cutValue) >= mid){
                        cutCount++;
                        cutValue = arr[i];

//                        System.out.println(cutValue);
                    }
                }

//                System.out.println(left + " " + right + " " + mid + " " + cutCount);

                if(cutCount > cut){
//                    result = Math.max(mid, result);
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }

            System.out.println(left - 1);
        }
    }
}
