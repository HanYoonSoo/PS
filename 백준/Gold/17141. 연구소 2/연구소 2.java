import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Node> virusList;
    static int result = Integer.MAX_VALUE;
    static int compare;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        grid = new int[N][N];
        virusList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(temp[j]);
                if(grid[i][j] == 2){
                    virusList.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[virusList.size()];

        dfs(0, 0);


        if(result == Integer.MAX_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(result);
        }
    }

    public static void dfs(int idx, int depth){
        if(depth == M){
            int[][] temp_grid = copy();

            compare = 0;
            spread_virus(temp_grid);

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(temp_grid[i][j] == 0){
                        compare = Integer.MAX_VALUE;
                        return;
                    }
                }
            }

            result = Math.min(compare, result);

            return;
        }

        for(int i = idx; i < virusList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void spread_virus(int[][] temp_grid){
        Queue<Node> q = new LinkedList<>();

        int[][] time = new int[N][N];

        for(int i = 0; i < virusList.size(); i++){
            if(visited[i]){
                q.offer(virusList.get(i));
            }
        }

        compare = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int dist = time[node.x][node.y];

            compare = Math.max(compare, dist);

            if(result <= compare){
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if(temp_grid[nx][ny] == 0 && time[nx][ny] == 0){
                    q.offer(new Node(nx, ny));
                    time[nx][ny] = dist + 1;
                    temp_grid[nx][ny] = 2;
                }

            }
        }
    }
    public static int[][] copy(){
        int[][] temp_grid = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 2){
                    temp_grid[i][j] = 0;
                }
                else{
                    temp_grid[i][j] = grid[i][j];
                }
            }
        }

        for(int i = 0; i < virusList.size(); i++){
            if(visited[i]){
                temp_grid[virusList.get(i).x][virusList.get(i).y] = 2;
            }
        }

        return temp_grid;
    }
}


class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
