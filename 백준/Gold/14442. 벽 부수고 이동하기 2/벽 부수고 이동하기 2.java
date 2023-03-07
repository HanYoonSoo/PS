import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] graph;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int K;

    public static int bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, new Point(1, 1), 0));
        visited[1][1][0] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            int count = curr.cnt;
            int x = curr.pos.x;
            int y = curr.pos.y;
            int wall = curr.wall;

            if(x == N && y == M){
                return count;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(1 <= nx && nx <= N && 1 <= ny && ny <= M){
                    if(graph[nx][ny] == 0 && !visited[nx][ny][wall]){
                        q.add(new Node(count + 1, new Point(nx, ny), wall));
                        visited[nx][ny][wall] = true;
                    }
                    else if(graph[nx][ny] == 1 && wall < K && !visited[nx][ny][wall + 1]){
                        q.add(new Node(count + 1, new Point(nx, ny), wall + 1));
                        visited[nx][ny][wall + 1] = true;
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        K = Integer.parseInt(temp[2]);

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][K + 1];

        for(int i = 1; i < N + 1; i++){
            String str = br.readLine();
            for(int j = 1; j < M + 1; j ++){
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());
    }

    static class Node{
        int cnt;
        Point pos;
        int wall;

        public Node(int cnt, Point pos, int wall){
            this.cnt = cnt;
            this.pos = pos;
            this.wall = wall;
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
