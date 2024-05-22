import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static String[][] grid;
    static boolean[][] visited;

    static class Node implements Comparable<Node> {
        int y;
        int x;
        String s;

        public Node(int y, int x, String s){
            this.y = y;
            this.x = x;
            this.s = s;
        }

        @Override
        public int compareTo(Node o2) {
            if (this.s.equals("E") && !o2.s.equals("E")) {
                return -1;
            } else if (!this.s.equals("E") && o2.s.equals("E")) {
                return 1;
            } else if (this.s.equals("P") && !o2.s.equals("P")) {
                return -1;
            } else if (!this.s.equals("P") && o2.s.equals("P")) {
                return 1;
            } else {
                if (this.y == o2.y) {
                    return this.x - o2.x;
                }
                return this.y - o2.y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        grid = new String[N][M];
        visited = new boolean[N][M];

        int start_x = 0;
        int start_y = 0;
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++){
                if(line[j].equals("S")){
                    start_y = i;
                    start_x = j;
                }
                grid[i][j] = line[j];
            }
        }

        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};

        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(start_y, start_x, "S"));
        visited[start_y][start_x] = true;

        int score = 0;

        while(!q.isEmpty()){
            Node curr = q.poll();

//            System.out.println(curr.y + " " + curr.x);

            if(curr.s.equals("E")){
                System.out.println(Math.max(score, 0));
                return;
            }

            if(!curr.s.equals("S"))
                score += checkDanger(curr.y, curr.x);

            if(curr.s.equals("P")){
                score -= 3;
            }


            for(int i = 0; i < 4; i++){
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx, grid[ny][nx]));
                }
            }
        }

        System.out.println(Math.max(score, 0));
    }

    private static int checkDanger(int y, int x) {
        int danger = 0;

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0){
                    continue;
                }

                int ny = y + i;
                int nx = x + j;

                if(0 <= nx && nx < M && 0 <= ny && ny < N){
                    if(grid[ny][nx].equals("P")) {
                        danger += 1;
//                        System.out.println(ny + " " + nx);
                    }
                }
            }
        }

//        System.out.println(danger);
        return danger;
    }
}
