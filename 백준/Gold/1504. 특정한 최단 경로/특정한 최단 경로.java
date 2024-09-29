import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int end;
        int w;

        public Edge(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    static int N, E;
    static List<List<Edge>> graph;
    static int[] distanceV;
    static int[] distanceV1;
    static int[] distanceV2;
    static int INF = 2_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, w));
            graph.get(end).add(new Edge(start, w));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        distanceV = new int[N + 1];
        distanceV1 = new int[N + 1];
        distanceV2 = new int[N + 1];

        Arrays.fill(distanceV, INF);
        Arrays.fill(distanceV1, INF);
        Arrays.fill(distanceV2, INF);

        dijkstra(1, distanceV, v1, v2);
        dijkstra(v1, distanceV1, v2, N);
        dijkstra(v2, distanceV2, v1, N);

        long resultV1 = 0;
        resultV1 += distanceV[v1];
        resultV1 += distanceV1[v2];
        resultV1 += distanceV2[N];

        long resultV2 = 0;
        resultV2 += distanceV[v2];
        resultV2 += distanceV2[v1];
        resultV2 += distanceV1[N];

        if (resultV1 >= INF && resultV2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(resultV1, resultV2));
        }

    }

    public static void dijkstra(int start, int[] distance, int... need) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        boolean[] isVisited = new boolean[N + 1]; // 방문 배열 추가

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (isVisited[curr.end]) {
                continue;
            }

            isVisited[curr.end] = true;

            for (Edge edge : graph.get(curr.end)) {
                if (distance[edge.end] > distance[curr.end] + edge.w) {
                    distance[edge.end] = distance[curr.end] + edge.w;

                    pq.add(new Edge(edge.end, distance[edge.end]));
                }
            }

            // 모든 목표 노드가 방문되었는지 확인하는 조건으로 수정
            boolean allVisited = true;
            for (int node : need) {
                if (!isVisited[node]) {
                    allVisited = false;
                    break;
                }
            }

            if (allVisited) {
                return;
            }
        }
    }
}
