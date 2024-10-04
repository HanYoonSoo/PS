import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int N = 5;
    static final int M = 9;
    static char[][] arr;
    static int minPin, minMove;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            arr = new char[N][M];
            int pinCount = 0;

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == 'o') pinCount++;
                }
            }

            minPin = pinCount;
            minMove = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 'o') {
                        dfs(pinCount, 0, i, j);
                    }
                }
            }

            br.readLine();  // 빈 줄 처리
            sb.append(minPin).append(" ").append(minMove).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int remainPin, int moveCount, int y, int x) {
        // 현재 핀 개수가 최소 핀 개수보다 작거나 같으면 값 갱신
        if (remainPin < minPin || (remainPin == minPin && moveCount < minMove)) {
            minPin = remainPin;
            minMove = moveCount;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 인접한 곳에 핀이 있는지 확인
            if (isInBounds(ny, nx) && arr[ny][nx] == 'o') {
                int nny = ny + dy[i];
                int nnx = nx + dx[i];

                // 그 다음 칸이 비어있으면 점프 가능
                if (isInBounds(nny, nnx) && arr[nny][nnx] == '.') {
                    // 점프 수행 (핀을 이동시키고 중간 핀 제거)
                    arr[y][x] = arr[ny][nx] = '.';
                    arr[nny][nnx] = 'o';

                    // DFS 재귀 호출
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < M; k++) {
                            if (arr[j][k] == 'o') {
                                dfs(remainPin - 1, moveCount + 1, j, k);
                            }
                        }
                    }

                    // 이전 상태로 복구
                    arr[y][x] = arr[ny][nx] = 'o';
                    arr[nny][nnx] = '.';
                }
            }
        }
    }

    public static boolean isInBounds(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
