import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<List<Edge>> grid = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            grid.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            grid.get(a).add(new Edge(b, c));
        }

        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(K, 0));
        dist[K] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.end])
                continue;

            visited[curr.end] = true;

            for(Edge edge : grid.get(curr.end)){
                if(dist[edge.end] > dist[curr.end] + edge.weight){
                    dist[edge.end] = dist[curr.end] + edge.weight;
                }

                pq.add(new Edge(edge.end, dist[edge.end]));
            }
        }

        for(int i = 1; i <= V; i++){
            if(dist[i] != Integer.MAX_VALUE){
                System.out.println(dist[i]);
            } else{
                System.out.println("INF");
            }
        }

    }
}
