import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] bitCount = new int[32];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            int n = 0;

            while(num > 1){
                bitCount[n] += num % 2;
                num /= 2;
                n++;
            }

            bitCount[n] += num;
        }

        int max = 0;

        for(int i = 0; i < 32; i++){
            max = Math.max(max, bitCount[i]);
        }

        System.out.println(max);
    }
}
