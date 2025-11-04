import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        int[] result = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                result[i] = 1;
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int node : graph[curr]) {
                result[node] = result[curr] + 1;
                inDegree[node]--;
                if(inDegree[node] == 0) {
                    q.add(node);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
