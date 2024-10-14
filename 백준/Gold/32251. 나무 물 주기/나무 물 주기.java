import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ32251 {
    static class Node {
        int v;
        long w;
        List<Integer> child;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
            this.child = new ArrayList<>();
        }
    }

    static int N, Q;
    static List<List<Integer>> graph;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        tree = new Node[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            tree[i] = new Node(i, 0);
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            tree[i].w = Long.parseLong(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int node : graph.get(curr)){
                if(!visited[node]){
                    visited[node] = true;
                    tree[curr].child.add(node);
                    q.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                dfs(u, x);
            } else {
                sb.append(tree[u].w).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int parent, long x) {
        if(x <= tree[parent].w){
            tree[parent].w += x;
            return;
        } else{
            x -= tree[parent].w;
            tree[parent].w += tree[parent].w;

            int childCount = tree[parent].child.size();

            if(childCount == 0)
                return;

            for(int child : tree[parent].child){
                dfs(child, x / childCount);
            }
        }
    }
}
