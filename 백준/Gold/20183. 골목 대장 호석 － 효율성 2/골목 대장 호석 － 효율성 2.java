import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int end;
        long w;

        public Edge(int end, long w){
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e){
            return Long.compare(this.w, e.w);
        }

    }

    static int N;
    static int M;
    static long C;
    static int A;
    static int B;

    static List<List<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        C = Long.parseLong(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, w));
            graph.get(end).add(new Edge(start, w));
        }

        long left = 1;
        long right = C;

        long result = Long.MAX_VALUE;

        while(left <= right){
            long mid = (left + right) / 2;

//            System.out.println(left + " " + mid + " " + right);

            if(dijkstra(mid)){
                result = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(result == Long.MAX_VALUE ? -1 : result);
    }

    public static boolean dijkstra(long mid){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        long[] dist = new long[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        pq.add(new Edge(A, 0));

        dist[A] = 0;

//        int max = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            int node = curr.end;
            long w = curr.w;

            if(dist[node] < w){
                continue;
            }

            for(Edge edge : graph.get(node)){
                long compute = w + edge.w;

                if(dist[edge.end] > compute && edge.w <= mid && compute <= C){
                    dist[edge.end] = compute;
                    pq.add(new Edge(edge.end, compute));
                }
            }
        }

        return dist[B] <= C;
    }
}

//7 7 1 7 6
//1 2 3
//2 6 1
//1 3 2
//3 4 1
//4 5 2
//5 6 1
//6 7 1