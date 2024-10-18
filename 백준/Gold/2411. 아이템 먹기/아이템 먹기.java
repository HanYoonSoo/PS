import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N + 1][M + 1];

        List<int[]> items = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            grid[y][x] = 1;
            items.add(new int[]{y, x});
        }

        items.add(new int[]{N, M});

        Collections.sort(items, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });


        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            grid[y][x] = 2;
        }

        int[][] dp = new int[N + 1][M + 1];

        dp[1][1] = 1;

        int sX = 1;
        int sY = 1;

        for(int[] item : items){
            int eY = item[0];
            int eX = item[1];

            for(int i = sY; i <= eY; i++){
                for(int j = sX; j <= eX; j++){
                    if(i == sY && j == sX)
                        continue;

                    if(grid[i][j] == 2){
                        dp[i][j] = 0;
                    } else{
                        if(grid[i - 1][j] != 2){
                            dp[i][j] += dp[i - 1][j];
                        }

                        if(grid[i][j - 1] != 2){
                            dp[i][j] += dp[i][j - 1];
                        }
                    }
                }
            }

            sY = eY;
            sX = eX;
        }

        System.out.println(dp[N][M]);
    }

}
