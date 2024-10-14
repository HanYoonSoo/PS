import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph;
    static List<List<Integer>> tree;
    static boolean[] visited;
    static long[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Graph and tree initialization
        graph = new ArrayList<>();
        tree = new ArrayList<>();
        visited = new boolean[N + 1];
        cost = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        // Reading edges
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // Reading costs
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        // Build tree using BFS
        graphBFS(1);

        // Processing queries
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int u = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                treeDFS(u, x);
            } else if (command == 2) {
                int u = Integer.parseInt(st.nextToken());
                sb.append(cost[u]).append("\n");
            }
        }

        System.out.println(sb);
    }

    // BFS to create the tree structure
    public static void graphBFS(int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int neighbor : graph.get(temp)) {
                if (!visited[neighbor]) {
                    tree.get(temp).add(neighbor);
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    // DFS to distribute the value x across the tree
    public static void treeDFS(int start, long x) {
        if (x <= cost[start]) {
            cost[start] += x;
            return;
        } else {
            x -= cost[start];
            cost[start] += cost[start];

            // Distribute to children
            int childCount = tree.get(start).size();
            if (childCount == 0) return;  // No children to distribute to

            for (int child : tree.get(start)) {
                treeDFS(child, x / childCount);
            }
        }
    }
}
