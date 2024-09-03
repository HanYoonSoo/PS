import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 010
     * 001
     * 011
     *
     * 101
     * 110
     * 100
     *
     * 010
     * 110
     * 100
     *
     * 100
     * 000
     * 100
     *
     * 000
     * 100
     * 000
     *
     * 00
     * 01
     *
     * 11
     * 10
     *
     * 00
     * 10
     *
     * 10
     * 00
     *
     * 00
     * 00
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int count = 0;
        for(int j = M - 1; j >= 0; j--){
            for(int i = N - 1; i >= 0; i--){
                if(arr[i][j] == 1){
                    for(int k = 0; k <= i; k++){
                        for(int l = 0; l <= j; l++){
                            arr[k][l] ^= 1;
                        }
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
