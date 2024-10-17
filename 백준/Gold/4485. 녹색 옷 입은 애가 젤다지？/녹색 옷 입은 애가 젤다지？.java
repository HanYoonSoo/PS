import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int idx = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }

            int[][] grid = new int[N][N];

            StringTokenizer st;

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

            pq.add(new int[]{0, 0, grid[0][0]});

            int[][] visited = new int[N][N];

            for(int i = 0; i < N; i++){
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }

            visited[0][0] = grid[0][0];

            while(!pq.isEmpty()){
                int[] curr = pq.poll();

                int y = curr[0];
                int x = curr[1];
                int count = curr[2];

                if(y == N - 1 && x == N - 1){
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if(0 <= ny && ny < N && 0 <= nx && nx < N){
                        if(count + grid[ny][nx] < visited[ny][nx]){
                            visited[ny][nx] = count + grid[ny][nx];
                            pq.add(new int[]{ny, nx, visited[ny][nx]});
                        }
                    }
                }
            }



            sb.append("Problem ").append(idx++).append(": ").append(visited[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
