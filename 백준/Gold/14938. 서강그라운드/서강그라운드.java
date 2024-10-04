import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] item = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = new int[N + 1][N + 1];


        for(int i = 1; i <= N; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }


        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = w;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(i != j && graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE)
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

//        for(int i = 1; i <= N; i++){
//            System.out.println(i);
//            for(int j = 1; j <= N; j++){
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;

        for(int i = 1; i <= N; i++){
            int sum = item[i];
            for(int j = 1; j <= N; j++){
                if(i != j){
                    if(graph[i][j] <= M){
                        sum += item[j];
                    }
                }
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);


    }
}

//1000000