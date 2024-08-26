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

        int[][] grid = new int[N][M];

        int[] sumArr = new int[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                sum += grid[j][i];
//                System.out.println(grid[j][i]);
            }
            sumArr[i] = sum;
//            System.out.println(sum);
        }

        int length = Integer.parseInt(br.readLine());

        int max = 0;
        for(int i = 0; i < length; i++){
            max += sumArr[i];
        }

//        System.out.println(max);

        int window = max;
        for(int i = length; i < M; i++){
            window += sumArr[i] - sumArr[i - length];
//            System.out.println(sumArr[i] + " " + sumArr[i - length] + " " + window);
            if(window > max)
                max = window;
        }

        System.out.println(max);
    }
}
