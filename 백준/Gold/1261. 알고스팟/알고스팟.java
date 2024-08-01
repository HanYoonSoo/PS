import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split("");
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(arr[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        q.add(new int[]{0, 0, 0});

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int count = curr[2];

//            System.out.println(y + " " + x + " " + (count));

            if(y == (N - 1) && x == (M - 1)){
                System.out.println(count);
                break;
            }


            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && grid[ny][nx] == 0){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, count});
                } else if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && grid[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, count + 1});
                }
            }

        }

//        System.out.println(min);
    }
}
