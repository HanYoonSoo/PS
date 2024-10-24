import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int end;
        int kind;

        public Node(int end, int kind){
            this.end = end;
            this.kind = kind;
        }

        @Override
        public boolean equals(Object obj){
            Node n = (Node) obj;

            return this.end == n.end && this.kind == n.kind;
        }

        @Override
        public int hashCode(){
            return Objects.hash(end, kind);
        }
    }

    static class Info{
        int start;
        int end;

        public Info(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj){
            Info i = (Info) obj;

            return this.end == i.end && this.start == i.start;
        }

        @Override
        public int hashCode(){
            return Objects.hash(start, end);
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        List<Set<Node>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new HashSet<>());
            if(i >= 1){
                parent[i] = i;
            }
        }

        StringTokenizer st;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            String kind = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(kind.equals("E")){
                graph.get(start).add(new Node(end, -1));
                graph.get(end).add(new Node(start, - 1));
            } else{
                graph.get(start).add(new Node(end, 1));
                graph.get(end).add(new Node(start, 1));
            }
        }

        for(int i = 1; i <= N; i++){
            Set<Info> result = new HashSet<>();
            for(Node node : graph.get(i)){
                if(node.kind == -1){
                    for(Node n : graph.get(node.end)){
                        if(n.kind == -1 && i != n.end){
                            result.add(new Info(i, n.end));
//                            graph.get(i).add(new int[]{arr[0], 1});
                            result.add(new Info(n.end, i));
                        }
                    }
                }
            }

            for(Info info : result){
                graph.get(info.start).add(new Node(info.end, 1));
            }
        }

//        for(int i = 1; i <= N; i++){
//            for(Node node : graph.get(i)){
//                System.out.println(node.end + " " + node.kind);
//            }
//            System.out.println();
//        }

        for(int i = 1; i <= N; i++){
            for(Node node : graph.get(i)){
                if(node.kind == 1 && parent[i] != parent[node.end]){
                    union(i, node.end);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++){
            set.add(parent[i]);
        }

        System.out.println(set.size());
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);

        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }

    public static int find_parent(int p){
        if(parent[p] == p){
            return p;
        }

        parent[p] = find_parent(parent[p]);

        return parent[p];
    }
}
