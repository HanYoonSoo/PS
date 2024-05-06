import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있음
     * N명의 학생이 X번 마을에 보여서 파티를 벌임.
     * 이 마을 사이에는 M개의 단방향 도로들이 있고 각 i번째 길을 지나는데 T_i의 시간을 소비
     * 각각의 학생들을 파티에 참석하기 위해 걸어갔다가 다시 그들의 마을로 돌아와야 함.
     * 하지만, 최단 시간에 오고 가기를 원함
     * 단방향이라 오고 가는 길이 다를지도 모름
     * 가장 많은 시간을 소비하는 학생이 소비하는 시간
     */
    static class Edge implements Comparable<Edge>{
        int node;
        int w;

        public Edge(int node, int w){
            this.node = node;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    static int N;
    static int M;
    static int X;
    static List<List<Edge>> graph;
    static List<List<Edge>> reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            reverseGraph.get(end).add(new Edge(start, weight));
        }

        int[] dist1 = dijkstra(graph);
        int[] dist2 = dijkstra(reverseGraph);

        int result = 0;

        for(int i = 1; i <= N; i++){
            result = Math.max(result, dist1[i] + dist2[i]);
        }

        System.out.println(result);
    }

    public static int[] dijkstra(List<List<Edge>> graph){
        int[] dist = new int[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[X] = 0;

        boolean[] visited = new boolean[N + 1];

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            int curr = edge.node;

            if(!visited[curr]){
                visited[curr] = true;

                for(Edge e : graph.get(curr)){
                    if(!visited[e.node] && dist[e.node] > dist[curr] + e.w){
                        dist[e.node] = dist[curr] + e.w;
                        pq.add(new Edge(e.node, dist[e.node]));
                    }
                }
            }
        }

        return dist;
    }
}
