import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // EOF가 나올 때까지 반복
        while ((input = br.readLine()) != null && !input.isEmpty()) {

            int x = Integer.parseInt(input) * 10000000;

            // 두번째 입력: N (블록의 개수)
            int N = Integer.parseInt(br.readLine());

            // 블록 크기 배열 생성
            int[] arr = new int[N];

            // N개의 블록 크기 입력 받음
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            // 블록 크기 정렬
            Arrays.sort(arr);

            int p1 = 0;
            int p2 = N - 1;

            boolean compare = false;

            // 두 포인터를 사용한 탐색
            while (p1 < p2) {
                int sum = arr[p1] + arr[p2];
                if (sum < x) {
                    p1++;
                } else if (sum > x) {
                    p2--;
                } else {
                    compare = true;
                    break;
                }
            }

            // 결과 출력
            if (compare) {
                System.out.println("yes " + arr[p1] + " " + arr[p2]);
            } else {
                System.out.println("danger");
            }

        }
    }
}

