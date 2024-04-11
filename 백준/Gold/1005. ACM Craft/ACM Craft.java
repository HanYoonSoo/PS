import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] inDegree = new int[N + 1];

            int[] D = new int[N + 1];
            ArrayList<Integer>[] graph = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                D[i] = Integer.parseInt(st.nextToken());
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                inDegree[b]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] dp = new int[N + 1];

            Queue<Integer> q = new LinkedList<>();

            for(int i = 1; i <= N; i++){
                if(inDegree[i] == 0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int station = q.poll();
                dp[station] += D[station];

                if(W == station){
                    System.out.println(dp[station]);
                    break;
                }

                for(int next : graph[station]){
                    dp[next] = Math.max(dp[next], dp[station]);
                    inDegree[next]--;

                    if(inDegree[next] == 0){
                        q.add(next);
                    }
                }
            }
        }
    }
}
