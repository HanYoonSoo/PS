import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.StringTokenizer;

public class Main {

    /**
     * N개의 센서와 K개의 집중국
     * 집중국은 센서의 수신 가능 영역을 조절할 수 있다.
     * 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타나게 됨
     * 정렬한 다음 바로 다음 좌표와의 차이를 구해서 저장
     * 그 후 정렬, N - K개 <- 기지국을 세운 나머지들의 합 계산
     *
     * 입력 예)
     * 6 <- N
     * 2 <- K
     * 1 6 9 3 6 7 <- 센서의 좌표
     *
     * 출력 예)
     * 5
     *
     * 1 3 6 6 7 9
     * 2 3 0 1 2
     * 입력 예2)
     * 10
     * 5
     * 20 3 14 6 7 8 18 10 12 15
     *
     * 출력 예)
     * 7
     *
     * 3 6 7 8 10 12 14 15 18 20
     *
     * 3 1 1 2 2 2 1 3 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        int[] distance = new int[N - 1];

        for(int i = 0; i < N - 1; i++){
            distance[i] = number[i + 1] - number[i];
        }

        Arrays.sort(distance);

        int result = 0;

        for(int i = 0; i < N - K; i++){
            result += distance[i];
        }

        System.out.println(result);
    }
}
