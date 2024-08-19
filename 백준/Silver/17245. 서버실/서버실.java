import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    static int[][] serverArray = null;
    static long sum = 0; // 서버실에 들어가 있는 컴퓨터의 총 갯수

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        serverArray = new int[size][size];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                int number = Integer.parseInt(input[j]);
                serverArray[i][j] = number;
                max = Math.max(max, number); // 컴퓨터 최대 높이 저장
                sum += number;
            }
        }

        // 컴퓨터가 한 대도 없는 경우
        if (sum == 0) {
            bw.write(0 + "\n");
        } else {
            int start = 0;
            int end = max;
            int result = Integer.MAX_VALUE;
            while (start <= end) {
                int mid = (start + end) / 2;

                // 현재 mid 만큼 차가운 공기가 차올랐을 때 그 범위에 포함되는 컴퓨터의 갯수가(정상적으로 작동하는 컴퓨터가)
                // 전체 컴퓨터 갯수의 절반 이상인 경우
                if (halfCom(mid)) {
                    result = mid;
                    end = mid - 1; // 차가운 공기가 쌓이는 높이가 낮아지는 방향으로 범위 줄이기
                } else {
                    start = mid + 1;
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private boolean halfCom(int mid) {

        long activeCom = 0;
        for (int i = 0; i < serverArray.length; i++) {
            for (int j = 0; j < serverArray[i].length; j++) {
                if (serverArray[i][j] <= mid) {
                    activeCom += serverArray[i][j];
                } else {
                    activeCom += mid;
                }
            }
        }
        
        // 백분율 정확히 계산
        if (((double) activeCom / (double) sum) * 100 >= 50) {
            return true;
        } else {
            return false;
        }
    }
}