import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 입력)
     * ........
     * ........
     * ........
     * ........
     * ........
     * ........
     * ##......
     * ........
     *
     * 출력)
     * 0
     *
     * 아이디어)
     * 미리 벽의 좌표를 구해놓고 해당 좌표에 없는 값인 경우 큐에 삽입?
     */
    static boolean[][] walls = new boolean[8][8];
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 8; i++){
            String[] split = br.readLine().split("");

            for(int j = 0; j < 8; j++){
                if(split[j].equals("#")){
                    walls[i][j] = true;
                }
            }
        }

        if(solution()){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }

    public static boolean solution(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{7, 0, 0});

        int time = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int y = curr[0];
            int x = curr[1];
            int currTime = curr[2];

            if(time != currTime){
                moveWall();
                time++;
            }

            if(walls[y][x]){
                continue;
            }

            if(y < time || y == 0 && x == 7){
                return true;
            }


            for(int i = 0; i < 9; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < 8 && ny >= 0 && ny < 8){
                    if(!walls[ny][nx]){
                        q.add(new int[]{ny, nx, currTime + 1});
                    }
                }
            }
        }

        return false;
    }

    static void moveWall(){
        for(int i = 7; i >= 0; i--){
            for(int j = 0; j < 8; j++){
                if(walls[i][j]){
                    if(i < 7)
                        walls[i + 1][j] = true;
                    walls[i][j] = false;
                }
            }
        }
    }
}
