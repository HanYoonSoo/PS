import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] lights = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N;
        int result = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCover(N, lights, mid)) {
                result = mid;
                right = mid - 1; // 최소 높이 찾기
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canCover(int N, int[] lights, int h) {
        int currentX = 0;

        for (int x : lights) {
            if (x - h > currentX) {
                return false; // 중간에 어두운 구간 발생
            }
            currentX = Math.max(currentX, x + h);
        }

        return currentX >= N; // 끝까지 덮였는지
    }
}
