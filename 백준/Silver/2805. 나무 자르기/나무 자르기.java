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

        st = new StringTokenizer(br.readLine());

        int[] tree = new int[N];

        int max = 0;
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long left = 0;
        long right = max;

        while(left < right){
            long mid = (left + right) / 2;
            long takeTree = 0;

            for(int i = 0; i < N; i++){
                long temp = tree[i] - mid;

                if(temp > 0){
//                    System.out.println(mid + " " + temp);
                    takeTree += temp;
                }
            }

            if(takeTree < M){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}
