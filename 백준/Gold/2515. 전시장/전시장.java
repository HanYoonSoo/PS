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
        int S = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        int maxH = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr[i][0] = H;
            arr[i][1] = C;

            maxH = Math.max(maxH, H);
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        }));

        int left = S;
        int right = maxH;

        int max = 0;

        while(left <= right){
            int mid = (left + right) / 2;

//            System.out.print(left + " " + mid + " " + right);
            int sum = arr[0][1];

            int[] dp = new int[maxH + 1];

            for(int i = 0; i < N; i++){
                dp[arr[i][0]] = Math.max(arr[i][1], dp[arr[i][0]]);
            }

//            dp[arr[0][0]] = arr[0][1];
//
//            if(arr[1][0] - arr[0][0] >= mid){
//                dp[arr[1][0]] = arr[0][1] + arr[1][1];
//            } else{
//                dp[arr[1][0]] = Math.max(arr[0][1], arr[1][1]);
//            }

            for(int i = 1; i <= maxH; i++){
//                if(arr[i][0] - arr[i - 1][0] >= mid) {
//                    dp[arr[i][0]] = Math.max(dp[arr[i][0] - mid] + arr[i][1], dp[arr[i - 1][0]]);
////                    System.out.println(i + " " + dp[arr[i][0]]);
//                } else{
//                    dp[arr[i][0]] = Math.max(dp[arr[i - 1][0]], dp[arr[i - 2][0]] + arr[i][1]);
//                }

                if(i >= mid){
                    dp[i] = Math.max(dp[i - mid] + dp[i], dp[i - 1]);
                }
            }

            if(max <= dp[arr[N - 1][0]]){
                max = Math.max(dp[arr[N - 1][0]], max);
                right = mid - 1;
            } else{
                left = mid + 1;
            }

//            System.out.println(" " + sum);

//            for(int i = 0; i < N; i++){
//                System.out.print("H: " + arr[i][0] + " value: " + dp[arr[i][0]] + " ");
//            }

//            for(int i = 1; i <= maxH; i++){
//                System.out.print(i + " " + dp[i] + " ");
//            }

//            System.out.println();
        }

        System.out.println(max);
    }
}

//8 3
//8 30
//5 10
//14 50
//12 80
//16 50
//11 60
//15 40
//10 50