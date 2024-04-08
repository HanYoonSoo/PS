import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 주유소
     * 주유소 마다 리터강 가격이 주어지며 주유소 사이에 거리가 주어진다.
     * 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다.
     * 다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다.
     * 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다.
     * 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다.
     * 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다.
     * long으로 계산해야 할 듯. 또한, 그리디적으로 생각했을 때 다음 주유소로 갈 수 있을 만큼만 당장 충전
     *
     * 입력 예)
     * 4
     * 2 3 1
     * 5 2 4 1
     *
     * 출력 예)
     * 18
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] road = new long[N - 1];
        long[] oil = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N - 1; i++){
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            oil[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;

        long min_oil = oil[0];
        // 일단 현재 주유소에서 다음 주유소로 갈만큼은 충전.
        // 그 후, 도착한 주유소의 가격이 지금 가격보다 비싸면 이전 가격 적용 아님 교체
        for(int i = 0; i < N - 1; i++){
            min_oil = Math.min(min_oil, oil[i]);
            result += min_oil * road[i];
        }

        System.out.println(result);
    }
}
