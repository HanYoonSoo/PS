import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 그리디
     * 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다.
     * 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
     * 가장 시간이 적게 사람들을 줄을 세우는 방법
     * 입력 예)
     * 5
     * 3 1 4 3 2
     * 출력 예)
     * 32
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int result = 0;
        int compare = 0;

        for(int i = 0; i < N; i++){
            compare += num[i];
            result += compare;
        }

        System.out.println(result);
    }
}
