import java.util.*;

public class Main {
    static List<Integer>[] v = new ArrayList[50];
    static boolean[] visited = new boolean[50];

    static int dfs(int now) {
        int ret = 1;
        for (int next : v[now]) {
            if (visited[next]) continue;
            visited[next] = true;
            ret += dfs(next);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println("0");
            return;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            v[i] = new ArrayList<>();
            String a = sc.next();
            for (int t = 0; t < a.length(); t++) {
                if (a.charAt(t) == 'Y') {
                    v[i].add(t);
                    cnt++;
                }
            }
        }

        Arrays.fill(visited, false);
        cnt /= 2;
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                s.add(dfs(i));
            }
        }

        int sum = 0;
        for (int a : s) {
            sum += a - 1;
            if (a == 1) {
                System.out.println("-1");
                return;
            }
        }

        if (s.size() - 1 <= cnt - sum) {
            System.out.println(s.size() - 1);
        } else {
            System.out.println("-1");
        }
    }
}
