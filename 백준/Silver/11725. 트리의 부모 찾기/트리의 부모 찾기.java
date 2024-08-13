import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int root){
        visited[root] = true;

        for(int node : tree.get(root)){
            if(!visited[node]){
                parent[node] = root;
                dfs(node);
            }
        }
    }
}
