import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge{
        int end;
        int w;

        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }
    }

    static List<Edge>[] graph;
    static List<Integer>[] path;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, w));
//            graph[b].add(new Edge(a, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(start, end);

//        for(int i = 1; i <= N; i++){
//            System.out.print(dist[i] + " ");
//        }
//        System.out.println();

        StringBuilder sb = new StringBuilder();

        sb.append(dist[end]).append("\n");
        sb.append(path[end].size()).append("\n");
        path[end].forEach(p -> sb.append(p).append(" "));

        System.out.println(sb);
    }

    public static int[] dijkstra(int start, int end){
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        path = new ArrayList[N + 1];

        path[start] = new ArrayList<>();
        path[start].add(start);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.end == end){
                return dist;
            }

            if(dist[curr.end] < curr.w) {
                continue;
            }

            for(Edge edge : graph[curr.end]){
                if(dist[edge.end] > dist[curr.end] + edge.w){
                    dist[edge.end] = dist[curr.end] + edge.w;
                    List<Integer> list = new ArrayList<>(path[curr.end]);
                    list.add(edge.end);
                    path[edge.end] = list;
//                    System.out.println(curr.end + " " + edge.end + " " + dist[edge.end]);
                    pq.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }

        return dist;
    }
}
