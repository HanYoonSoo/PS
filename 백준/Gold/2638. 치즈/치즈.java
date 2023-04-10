import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        grid = new int[N][M];

        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");

            for(int j = 0; j < M; j++){
                if(Integer.parseInt(temp[j]) == 1){
                    count++;
                }
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int time = 0;
        while(count != 0){
            visited = new boolean[N][M];

            bfs();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(grid[i][j] >= 3){
                        grid[i][j] = 0;
                        count--;
                    }
                    else if(grid[i][j] == 2){
                        grid[i][j] = 1;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
    }

    public static void bfs(){
        Queue<CNode> q = new LinkedList<>();

        q.offer(new CNode(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            CNode cNode = q.poll();
            int x = cNode.x;
            int y = cNode.y;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]){
                    if(grid[nx][ny] >= 1){
                        grid[nx][ny] += 1;
                    }
                    else if(grid[nx][ny] == 0){
                        q.offer(new CNode(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

class CNode{
    int x;
    int y;

    public CNode(int x, int y){
        this.x = x;
        this.y = y;
    }
}
