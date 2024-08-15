import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] grid = new String[N][M];

        int jX = 0, jY = 0;

        List<int[]> fireStart = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++){
                if(line[j].equals("J")){
                    jY = i;
                    jX = j;
                } else if(line[j].equals("F")){
                    fireStart.add(new int[]{i, j});
                }

                grid[i][j] = line[j];
            }
        }

        int[][] fireVisited = new int[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();

        for(int[] fire : fireStart){
            q.add(new int[]{fire[0], fire[1], 1});
            fireVisited[fire[0]][fire[1]] = 1;
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int y = curr[0];
            int x = curr[1];
            int count = curr[2];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && fireVisited[ny][nx] == 0 && !grid[ny][nx].equals("#")){
                    fireVisited[ny][nx] = count + 1;
                    q.add(new int[]{ny, nx, count + 1});
                }
            }

//            System.out.println(1);
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(fireVisited[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("===============================");

        q = new LinkedList<>();
        int[][] jVisited = new int[N][M];

        q.add(new int[]{jY, jX, 1});
        jVisited[jY][jX] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int y = curr[0];
            int x = curr[1];
            int count = curr[2];

            if(0 == y || y == N - 1 || x == 0 || x == M - 1){
//                System.out.println(y + " " + x + " " + count + " " + fireVisited[y][x]);
                System.out.println(count);
//                System.exit(0);
                System.exit(0);
            }

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && jVisited[ny][nx] == 0 && !grid[ny][nx].equals("#")){
                    jVisited[ny][nx] = count + 1;
                    if(fireVisited[ny][nx] != 0 && fireVisited[ny][nx] <= jVisited[ny][nx]){
                        continue;
                    }
                    q.add(new int[]{ny, nx, count + 1});
                }
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(jVisited[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("IMPOSSIBLE");
    }
}
