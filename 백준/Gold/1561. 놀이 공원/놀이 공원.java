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

        int[] plays = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            plays[i] = Integer.parseInt(st.nextToken());
        }

        if(N <= M){
            System.out.println(N);
            return;
        }

        N -= M;

        long left = 1;
        long right = 2000000000L * 10000 * 30;

        long result = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;

            for(int i = 0; i < M; i++){
                count += mid / plays[i];
            }

//            System.out.println(left + " " + mid + " " + right + " " + count);

            if(count < N){
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        long preCount = 0;

        for(int i = 0; i < M; i++){
            preCount += (result - 1) / plays[i];
        }

        for(int i = 0; i < M; i++){
            if(result % plays[i] == 0){
                preCount++;

                if(preCount == N){
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
