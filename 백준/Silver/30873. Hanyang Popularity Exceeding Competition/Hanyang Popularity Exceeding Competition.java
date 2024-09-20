import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 유명인의 수

        int[][] celebrities = new int[N][2];  // [P_i, C_i]를 저장할 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            celebrities[i][0] = Integer.parseInt(st.nextToken());  // P_i (인기도)
            celebrities[i][1] = Integer.parseInt(st.nextToken());  // C_i (친화력)
        }

        // 그리디 탐색을 위해 순차적으로 유명인을 만난다.
        int currentPopularity = 0;  // 철민이의 현재 인기도
        int result = 0;  // 철민이가 얻을 수 있는 최대 인기도

        for (int i = 0; i < N; i++) {
            int P = celebrities[i][0];  // i번 유명인의 인기도
            int C = celebrities[i][1];  // i번 유명인의 친화력

            // 만날 수 있는지 확인: |P - currentPopularity| <= C
            if (Math.abs(P - currentPopularity) <= C) {
                currentPopularity++;  // 인기도가 1 올라감
                result++;  // 만난 사람 수 증가
            }
        }

        System.out.println(result);
    }
}
