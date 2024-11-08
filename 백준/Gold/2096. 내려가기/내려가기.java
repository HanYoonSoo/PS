import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 행(row)의 개수

        // 캐시 배열을 2 x 3 크기로 초기화
        int[][] min_cache = new int[2][3];
        int[][] max_cache = new int[2][3];

        // 첫 번째 행 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            int num = Integer.parseInt(st.nextToken());
            min_cache[0][j] = num;
            max_cache[0][j] = num;
        }

        // 두 번째 행부터 시작
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // min_cache와 max_cache 업데이트
            for (int j = 0; j < 3; j++) {
                int left = j > 0 ? j - 1 : 0;
                int right = j < 2 ? j + 1 : 2;

                // 최소값 계산
                min_cache[i % 2][j] = arr[j] + Math.min(
                        Math.min(min_cache[(i - 1) % 2][left], min_cache[(i - 1) % 2][j]),
                        min_cache[(i - 1) % 2][right]
                );

                // 최대값 계산
                max_cache[i % 2][j] = arr[j] + Math.max(
                        Math.max(max_cache[(i - 1) % 2][left], max_cache[(i - 1) % 2][j]),
                        max_cache[(i - 1) % 2][right]
                );
            }
        }

        // 마지막 행에 대한 최솟값과 최댓값 찾기
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < 3; j++) {
            min = Math.min(min, min_cache[(N - 1) % 2][j]);
            max = Math.max(max, max_cache[(N - 1) % 2][j]);
        }

        System.out.println(max + " " + min);
    }
}
