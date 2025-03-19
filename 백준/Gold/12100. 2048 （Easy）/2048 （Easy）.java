import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int count){
        if(count == 5){
            findMax();
            return;
        } else {
            int[][] temp = new int[N][N];

            for(int i = 0; i < N; i++){
                temp[i] = grid[i].clone();
            }

            for(int i = 0; i < 4; i++){
                move(i);
                dfs(count + 1);
                for(int j = 0; j < N; j++){
                    grid[j] = temp[j].clone();
                }
            }
        }
    }

    public static void move(int dir){
        switch (dir){
            //위
            case 0:
                for(int i = 0; i < N; i++){
                    int before = 0;
                    int idx = 0;
                    for(int j = 0; j < N; j++){
                        if(grid[j][i] != 0){
                            if(before != grid[j][i]){
                                before = grid[j][i];
                                grid[j][i] = 0;
                                grid[idx][i] = before;
                                idx++;
                            } else {
                                grid[idx - 1][i] = before * 2;
                                before = 0;
                                grid[j][i] = 0;
                            }
                        }
                    }
                }
                break;
            //아래
            case 1:
                for(int i = 0; i < N; i++){
                    int block = 0;
                    int idx = N - 1;
                    for(int j = N - 1; j >= 0; j--){
                        if(grid[j][i] != 0){
                            if(block != grid[j][i]){
                                block = grid[j][i];
                                grid[j][i] = 0;
                                grid[idx][i] = block;
                                idx--;
                            } else {
                                grid[idx + 1][i] = block * 2;
                                block = 0;
                                grid[j][i] = 0;
                            }
                        }
                    }
                }
                break;
            //왼
            case 2:
                for(int i = 0; i < N; i++){
                    int block = 0;
                    int idx = 0;
                    for(int j = 0; j < N; j++){
                        if(grid[i][j] != 0){
                            if(block != grid[i][j]){
                                block = grid[i][j];
                                grid[i][j] = 0;
                                grid[i][idx] = block;
                                idx++;
                            } else {
                                grid[i][idx - 1] = block * 2;
                                block = 0;
                                grid[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i < N; i++){
                    int block = 0;
                    int idx = N - 1;
                    for(int j = N - 1; j >= 0; j--){
                        if(grid[i][j] != 0){
                            if(block != grid[i][j]){
                                block = grid[i][j];
                                grid[i][j] = 0;
                                grid[i][idx] = block;
                                idx--;
                            } else {
                                grid[i][idx + 1] = block * 2;
                                block = 0;
                                grid[i][j] = 0;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result = Math.max(result, grid[i][j]);
            }
        }
    }
}
