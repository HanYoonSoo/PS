import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    /**
     * 파스칼 삼각형을 이용한 DP 문제
     * long을 사용해도 표현할 수 없기 때문에 Big Integer 이용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger[][] pascal = new BigInteger[101][101];

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    pascal[i][j] = BigInteger.ONE;
                } else{
                    pascal[i][j] = pascal[i - 1][j - 1].add(pascal[i - 1][j]);
                }
            }
        }

        System.out.println(pascal[N][M]);
    }
}
