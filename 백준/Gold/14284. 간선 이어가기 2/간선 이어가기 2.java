import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, S, T;
    static List<Edge>[] graph;

    static class Edge implements Comparable<Edge>{
        int node;
        int w;

        public Edge(int node, int w) {
            this.node = node;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra();

        System.out.println(dist[T]);
    }

    public static int[] dijkstra() {
        int[] dist = new int[N + 1];

        Arrays.fill(dist, 987654321);

        dist[S] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(S, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(dist[curr.node] < curr.w)
                continue;

            for(Edge edge : graph[curr.node]) {
                if(dist[edge.node] > curr.w + edge.w) {
                    dist[edge.node] = curr.w + edge.w;
                    pq.add(new Edge(edge.node, dist[edge.node]));
                }
            }
        }

        return dist;
    }
}
