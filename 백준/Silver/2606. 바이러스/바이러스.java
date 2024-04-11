import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /**
     * 단순 DFS, BFS
     *
     * 입력 예)
     * 7
     * 6
     * 1 2
     * 2 3
     * 1 5
     * 5 2
     * 5 6
     * 4 7
     *
     * 출력 예(
     * 4
     */

    static boolean[] visited;
    static int count;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        count = 0;
        visited = new boolean[V + 1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        dfs(1);

        for(int i = 1; i <= V; i++){
            if(!visited[i]){
                count++;
            }
        }

        System.out.println(V - count - 1);
    }

    public static void dfs(int start){
        visited[start] = true;

        for(int node : graph.get(start)){
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}
