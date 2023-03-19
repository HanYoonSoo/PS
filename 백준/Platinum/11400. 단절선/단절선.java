import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int count = 1;

    static int V, E;

    static List<ArrayList<Integer>> graph;
    static int[] order;

    static List<Edge> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        V = Integer.parseInt(temp[0]);
        E = Integer.parseInt(temp[1]);

        order = new int[V + 1];
        graph = new ArrayList<>();
        result = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= V; i++){
            if(order[i] == 0){
                dfs(i, 0);
            }
        }

        Collections.sort(result, (v1, v2) -> (v1.a == v2.a) ? v1.b - v2.b : v1.a - v2.a);

        StringBuilder sb = new StringBuilder();

        sb.append(result.size() + "\n");

        for(Edge edge : result){
            sb.append(edge.a + " " + edge.b+"\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }

    public static int dfs(int vertex, int parent) {
        order[vertex] = count++;
        int compare = order[vertex];

        for(int next : graph.get(vertex)){
            if(next == parent)
                continue;

            if(order[next] == 0){
                int minValue = dfs(next, vertex);

                if(minValue > order[vertex]){
                    if(next > vertex){
                        result.add(new Edge(vertex, next));
                    }
                    else{
                        result.add(new Edge(next, vertex));
                    }
                }
                compare = Math.min(minValue, compare);
            }
            else{
                compare = Math.min(compare, order[next]);
            }
        }

        return compare;
    }

}

class Edge{
    int a;
    int b;

    public Edge(int a, int b){
        this.a = a;
        this.b = b;
    }
}
