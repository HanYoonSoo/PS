import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다.
     * 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
     * 배열 A와 B의 인덱스는 1부터 시작한다.
     *
     * B[k] = x에서 x는 k보다 작은 수이다.
     *
     * 이 x에 관한 이분 탐색을 수행하여 답을 구한다.
     * x의 개수를 단(구구단)의 수로 나눠주며 그것을 실제 K값과 비교한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1;
        long right = K;

        while(left < right){
            long mid = (left + right) / 2;

            long count = 0;


            /*
             *  임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수
             *  누적 합을 구한다.
             *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
             */
            for(int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            }

            if(count < K){
                left = mid + 1;
            } else if(count >= K){
                right = mid;
            }
        }

        System.out.println(left);
    }
}
