import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Sub{
        int value;
        int idx;

        public Sub(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        Sub[] subArr = new Sub[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[i][0] = A;
            arr[i][1] = B;

            subArr[i] = new Sub(A - B, i);
        }

        Arrays.sort(subArr, ((o1, o2) -> Math.abs(o2.value) - Math.abs(o1.value)));

        // 5000
        // 6000 1000
        // 2500 2500
        // 2500 2500
        // 2500 2500
        int result = 0;
        for(int i = 0; i < N; i++){
            int value = subArr[i].value;
            if(X - 5000 >= (N - 1 - i) * 1000 && value > 0){
                X -= 5000;
                result += arr[subArr[i].idx][0];
            } else{
                X -= 1000;
                result += arr[subArr[i].idx][1];
            }
        }

        System.out.println(result);
    }
}

// 40 10
// 21 10
// 50 40