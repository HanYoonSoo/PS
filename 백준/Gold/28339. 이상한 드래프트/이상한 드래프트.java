import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Map<Integer, PriorityQueue<Integer>> playerMax = new HashMap<>();

            // 선수의 최고 능력을 관리하는 우선순위 큐 초기화
            for (int i = 1; i <= 9; i++) {
                playerMax.put(i, new PriorityQueue<>((o1, o2) -> o2 - o1));
            }

            int[][] player = new int[N][2];

            // 선수와 능력치 정보 입력 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int P = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());

                player[i][0] = P;
                player[i][1] = A;
            }

            int total = 0;
            Set<Integer> set = new HashSet<>();

            // 처음 K명의 선수에 대한 처리
            for (int i = 0; i < K; i++) {
                set.add(player[i][0]);
                playerMax.get(player[i][0]).add(player[i][1]);
            }

            // 각 선수별 최고 능력치 합계 계산
            for (int P : playerMax.keySet()) {
                if (!playerMax.get(P).isEmpty()) { // NullPointerException 방지
                    total += playerMax.get(P).peek();
                }
            }

            int max = 0;

            // 처음에 9명의 서로 다른 선수로 구성된 경우의 처리
            if (set.size() == 9) {
                max = Math.max(total, max);
            }

            // 슬라이딩 윈도우 방식으로 처리
            for (int i = 1; i < N - K + 1; i++) {
                // 이전 윈도우의 첫 번째 선수 제거
                if (!playerMax.get(player[i - 1][0]).isEmpty() && playerMax.get(player[i - 1][0]).peek() == player[i - 1][1]) {
                    total -= playerMax.get(player[i - 1][0]).poll();

                    if (!playerMax.get(player[i - 1][0]).isEmpty()) {
                        total += playerMax.get(player[i - 1][0]).peek();
                    } else {
                        set.remove(player[i - 1][0]);
                    }
                } else {
                    playerMax.get(player[i - 1][0]).remove(Integer.valueOf(player[i - 1][1]));

                    if (playerMax.get(player[i - 1][0]).isEmpty()) {
                        set.remove(player[i - 1][0]);
                    }
                }

                // 새로운 윈도우의 마지막 선수 추가
                if (!playerMax.get(player[i + K - 1][0]).isEmpty()) {
                    if (playerMax.get(player[i + K - 1][0]).peek() < player[i + K - 1][1]) {
                        total -= playerMax.get(player[i + K - 1][0]).peek();
                        playerMax.get(player[i + K - 1][0]).add(player[i + K - 1][1]);
                        total += player[i + K - 1][1];
                    } else {
                        playerMax.get(player[i + K - 1][0]).add(player[i + K - 1][1]);
                    }
                } else {
                    set.add(player[i + K - 1][0]);
                    playerMax.get(player[i + K - 1][0]).add(player[i + K - 1][1]);
                    total += player[i + K - 1][1];
                }

                // 9명의 서로 다른 선수로 구성된 경우 처리
                if (set.size() == 9) {
                    max = Math.max(total, max);
                }
            }

            System.out.println(max);
        }
    }
}
