import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static List<List<Integer>> graph;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        inDegree = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            int curr;

            for(int j = 0; j < length - 1; j++){
                curr = Integer.parseInt(st.nextToken());
                graph.get(prev).add(curr);
                inDegree[curr]++;

                prev = curr;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        int compare = 0;

        while(!q.isEmpty()){
            Integer singer = q.poll();

            sb.append(singer + "\n");
            compare++;

            for(Integer i : graph.get(singer)){
                inDegree[i]--;

                if(inDegree[i] == 0){
                    q.add(i);
                }
            }

        }

        if(compare == N)
            System.out.println(sb);
        else
            System.out.println(0);
    }
}
