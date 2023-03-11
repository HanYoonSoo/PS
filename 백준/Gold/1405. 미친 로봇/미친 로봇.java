import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static double[] percent;
    static double result;
    // 동 서 북 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;

    public static void dfs(int x, int y, int depth, double total){
        if(depth == N){
            result += total;
            return;
        }

        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < 30 && 0 <= ny && ny < 30){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, total * percent[i]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        percent = new double[4];

        for(int i = 1; i < temp.length; i++){
            percent[i-1] = Integer.parseInt(temp[i]) * 0.01;
        }

        visited = new boolean[30][30];

        result = 0;

        dfs(15, 15, 0, 1);

        System.out.println(result);



    }
}
