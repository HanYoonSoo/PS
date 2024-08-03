import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;

    static class Edge implements Comparable<Edge>{
        int end;
        int weight;

        public Edge(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> reverseGraph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            reverseGraph.get(b).add(new Edge(a, w));
        }

        int[] dist1 = dijkstra(graph);
        int[] dist2 = dijkstra(reverseGraph);

        int result = 0;

        for(int i = 1; i <= N; i++){
            result = Math.max(result, dist1[i] + dist2[i]);
        }

        System.out.println(result);
    }

    private static int[] dijkstra(List<List<Edge>> graph) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(X, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.end])
                continue;

            visited[curr.end] = true;

            for(Edge e : graph.get(curr.end)){
                if(dist[e.end] > dist[curr.end] + e.weight){
                    dist[e.end] = dist[curr.end] + e.weight;
//                    System.out.println(dist[e.end]);
                }
                pq.add(new Edge(e.end, dist[e.end]));
            }
        }

        return dist;
    }
}
