import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int w;

        public Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge){
            return edge.w - this.w;
        }
    }

    static int N;
    static int M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 1;  i <= N; i++)
            parent[i] = i;

        int max = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(a, b, w));
        }

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(find_parent(start) == find_parent(end))
                break;

            union(curr.start, curr.end);
            max = curr.w;
        }


        if(find_parent(start) != find_parent(end))
            System.out.println(0);
        else
            System.out.println(max);
    }

    public static int find_parent(int p){
        if(parent[p] == p)
            return p;

        parent[p] = find_parent(parent[p]);

        return parent[p];
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}
