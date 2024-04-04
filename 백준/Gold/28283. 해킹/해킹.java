import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            A[i] = scanner.nextInt();
        }
        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            G.add(new ArrayList<>());
        }
        for (int i = 0; i < M; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            G.get(u).add(v);
            G.get(v).add(u);
        }
        int[] B = new int[Y];
        for (int i = 0; i < Y; ++i) {
            B[i] = scanner.nextInt();
        }
        int[] D = new int[N + 1];
        Arrays.fill(D, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < Y; ++i) {
            D[B[i]] = 0;
            q.add(B[i]);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : G.get(x)) {
                if (D[y] == -1) {
                    D[y] = D[x] + 1;
                    q.add(y);
                }
            }
        }
        for (int i = 1; i <= N; ++i) {
            if (D[i] == -1 && A[i] != 0) {
                System.out.println("-1");
                return;
            }
        }
        long[] C = new long[N + 1];
        for (int i = 1; i <= N; ++i) {
            C[i] = (long) D[i] * A[i];
        }
        Arrays.sort(C);
        long ans = 0;
        for (int i = N; i > N - X; --i) {
            ans += C[i];
        }
        System.out.println(ans);
    }
}
