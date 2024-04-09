import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 수직선과 같은 일직선상에 N개의 마을이 위치해 있다.
     * i번째 마을은 X[i]에 위치해 있으며,
     * A[i]명의 사람이 살고 있다.
     * 우체국을 세우려는데 각 사람들까지의 거리의 합이 최소가 되는 위치 세운다.
     * 마을이 아닌 사람들까지의 거리의 합
     * 가능한 경우가 여러 가지인 경우에는 더 작은 위치를 출력하도록 한다.
     *
     * |X[i]| ≤ 1,000,000,000, 1 ≤ A[i] ≤ 1,000,000,000 이며 모든 입력은 정수이다.
     *
     * 입력 예)
     * 3
     * 1 3
     * 2 5
     * 3 3
     *
     * 출력 예)
     * 2
     *
     * 사람의 수를 곱해서 우체국을 세울 위치를 고려해야 한다고 생각
     * 사람 수 * 거리가 최대가 되는 곳에? 그럼 거리의 기준은?
     * 아님 다 계산해서 최소가 되는 위치?
     * 총 인구수의 중간값의 가장 가까운 마을?
     */
    static class Pair implements Comparable<Pair> {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.first, o.first);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Pair> A = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            long first = Long.parseLong(st.nextToken());
            long second = Long.parseLong(st.nextToken());
            A.add(new Pair(first, second));
        }

        Collections.sort(A);

        for (int i = 1; i < N; ++i) {
            A.get(i).second += A.get(i - 1).second;
        }

        int idx = 0;
        while (A.get(idx).second < (A.get(N - 1).second + 1) / 2) {
            idx++;
        }

        System.out.println(A.get(idx).first);

    }
}

