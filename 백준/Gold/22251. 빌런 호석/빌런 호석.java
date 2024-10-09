import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] number = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String X = st.nextToken();

        int zeroLen = K - X.length();

        X = "0".repeat(zeroLen).concat(X);

        int result = 0;

        for(int i = 1; i <= N; i++){
            if(i == Integer.parseInt(X))
                continue;
            String num = String.valueOf(i);

            zeroLen = K - num.length();

            num = "0".repeat(zeroLen).concat(num);

            int sum = 0;

            for(int j = 0; j < num.length(); j++){
                int[] numDigit = number[num.charAt(j) - '0'];
                int[] xDigit = number[X.charAt(j) - '0'];

                for(int k = 0; k < 7; k++){
                    if(numDigit[k] != xDigit[k]){
                        sum++;
                    }
                }
            }

            if(sum <= P){
                result++;
            }
        }


        System.out.println(result);
    }
}
