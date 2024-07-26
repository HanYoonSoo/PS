import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        bfs(R);

        for(int i = 1; i <= N; i++){
            if(!visited[i])
                System.out.println(0);
            else
                System.out.println(count[i]);
        }
    }

    private static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        q.add(r);

        visited[r] = true;

        while(!q.isEmpty()){
            Integer curr = q.poll();
            
            count[curr] = cnt++;

            List<Integer> nodes = graph.get(curr);

            nodes.sort(Collections.reverseOrder());

            for(Integer node : nodes){
                if(!visited[node]){
                    visited[node] = true;
                    q.add(node);
                }
            }

        }
    }
}
