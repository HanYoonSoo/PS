import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Edge>> graph;
    static boolean[] visited;
    static int[] dist;

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

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(Edge e : graph.get(1)){
            pq.add(e);
        }
        visited[1] = true;

        int result = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(!visited[curr.end]){
                visited[curr.end] = true;
                result += curr.weight;

                for(Edge e : graph.get(curr.end)){
                    pq.add(e);
                }
            }

        }

        System.out.println(result);
    }
}
