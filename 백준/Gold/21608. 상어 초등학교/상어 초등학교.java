import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 한 칸에는 학생 한 명의 자리만 가능
     * 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
     * 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
     * 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
     *
     * 입력 예)
     * 3
     * 4 2 5 1 7
     * 3 1 9 4 5
     * 9 8 1 2 3
     * 8 1 9 3 4
     * 7 2 3 4 8
     * 1 9 2 5 7
     * 6 5 2 3 4
     * 5 1 9 2 8
     * 2 9 3 1 4
     *
     * 출력 예)
     * 54
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int N = Integer.parseInt(br.readLine());

        int[][] student = new int[N * N + 1][4];

        int[][] grid = new int[N][N];

        StringTokenizer st;

        int result = 0;

        // 자리 배치 로직 수정
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                student[number][j] = Integer.parseInt(st.nextToken());
            }

            int maxFriend = -1, maxEmpty = -1, x = -1, y = -1;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (grid[j][k] == 0) {
                        int friendCount = 0, emptyCount = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = k + dx[dir];
                            int ny = j + dy[dir];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (grid[ny][nx] == 0) {
                                    emptyCount++;
                                } else {
                                    for (int friend : student[number]) {
                                        if (grid[ny][nx] == friend) {
                                            friendCount++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if (friendCount > maxFriend || (friendCount == maxFriend && emptyCount > maxEmpty) ||
                                (friendCount == maxFriend && emptyCount == maxEmpty && (j < y || (j == y && k < x)))) {
                            maxFriend = friendCount;
                            maxEmpty = emptyCount;
                            x = k;
                            y = j;
                        }
                    }
                }
            }
            grid[y][x] = number;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int num = grid[i][j];
                int count = 0;

                for(int dir = 0; dir < 4; dir++){
                    int nx = j + dx[dir];
                    int ny = i + dy[dir];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    for(int friend = 0; friend < 4; friend++){
                        if(grid[ny][nx] == student[num][friend]){
                            count++;
                        }
                    }
                }

                switch (count){
                    case 0:
                        result += 0;
                        break;
                    case 1:
                        result += 1;
                        break;
                    case 2:
                        result += 10;
                        break;
                    case 3:
                        result += 100;
                        break;
                    case 4:
                        result += 1000;
                        break;
                }
            }
        }
        System.out.println(result);
    }

//    public static void print(int[][] grid){
//        int N = 3;
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//    }
}
