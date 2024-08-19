import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N][N];

        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int height = Integer.parseInt(st.nextToken());
                grid[i][j] = height;
                sum += height;
                max = Math.max(height, max);
            }
        }

        int left = 0;
        int right = max;

        int result = Integer.MAX_VALUE;

        if(sum == 0){
            System.out.println(0);
            return;
        }

        while(left <= right){
            int mid = (left + right) / 2;

            long total = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(grid[i][j] <= mid){
                        total += grid[i][j];
                    } else{
                        total += mid;
                    }
                }
            }

            if((((double) total / (double) sum) * 100.0) >= 50){
                result = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
