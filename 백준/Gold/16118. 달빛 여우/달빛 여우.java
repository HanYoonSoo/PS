import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int end;
        int w;
        int oddEven;

        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }

        public Edge(int end, int w, int oddEven){
            this.end = end;
            this.w = w;
            this.oddEven = oddEven;
        }

        @Override
        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }

    static int N;
    static int M;
    static List<List<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, w * 2));
            graph.get(end).add(new Edge(start, w * 2));
        }

        int[] distFox = new int[N + 1];
        int[][] distWolf = new int[2][N + 1];

        dijkstra(distFox);
        dijkstraWolf(distWolf);

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(distFox[i] < Math.min(distWolf[0][i], distWolf[1][i])){
                count++;
            }

//            System.out.println(distFox[i] + " " + distWolf[i]);
        }

        System.out.println(count);
    }

    public static void dijkstra(int[] dist){
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.w > dist[curr.end]){
                continue;
            }

            int node = curr.end;
            int w = curr.w;

            for(Edge edge : graph.get(node)){
                if(w + edge.w < dist[edge.end]){
                    dist[edge.end] = w + edge.w;
                    pq.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
    }

    public static void dijkstraWolf(int[][] dist){
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);
        dist[0][1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(1, 0, 0));

//        for(Edge edge : graph.get(1)){
//            pq.add(edge)
//        }

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.w > dist[curr.oddEven][curr.end]){
                continue;
            }

            int node = curr.end;
            int w = curr.w;

            for(Edge edge : graph.get(node)){
                int total = w;
                int oddEven = 0;
                if(curr.oddEven == 0){
                    total += edge.w / 2;
                    oddEven = 1;
                } else{
                    total += edge.w * 2;
                    oddEven = 0;
                }

                if(total < dist[oddEven][edge.end]){
                    dist[oddEven][edge.end] = total;
                    pq.add(new Edge(edge.end, total, oddEven));
                }
            }
        }
    }
}
