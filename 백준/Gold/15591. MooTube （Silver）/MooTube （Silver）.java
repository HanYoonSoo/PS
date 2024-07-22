import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, Q;
    static List<List<Edge>> graph;

    static class Edge{
        int end;
        int usado;

        public Edge(int end, int usado){
            this.end = end;
            this.usado = usado;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, usado));
            graph.get(end).add(new Edge(start, usado));
        }

        for (int i = 1; i <= Q; i++){
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();

            q.add(V);
            visited[V] = true;

            int count = 0;

            while(!q.isEmpty()){
                Integer curr = q.poll();

                for(Edge edge : graph.get(curr)){
                    if(!visited[edge.end] && edge.usado >= K){
                        q.add(edge.end);
                        count++;
                        visited[edge.end] = true;
                    }
                }
            }

            System.out.println(count);
        }
    }

}
