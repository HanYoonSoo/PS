import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] count;
    static int cnt = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        count = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dfs(R);

        for(int i = 1; i <= N; i++){
            if(!visited[i])
                System.out.println(0);
            else
                System.out.println(count[i]);
        }
    }

    private static void dfs(int r) {
        visited[r] = true;
        count[r] = cnt++;

        List<Integer> nodes = graph.get(r);

        nodes.sort(Collections.reverseOrder());

        for(int i = 0; i < nodes.size(); i++){
            if(!visited[nodes.get(i)]) {
                dfs(nodes.get(i));
            }
        }

    }
}
