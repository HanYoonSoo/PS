import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] sudoku = new int[9][9];
    static int count = 0;
    static int[][] empty = new int[82][2];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int input = Integer.parseInt(st.nextToken());
                sudoku[i][j] = input;
                if (input == 0) {
                    empty[count][0] = i;
                    empty[count][1] = j;
                    count++;
                }
            }
        }
        paintSudoku(0);
    }

    private static void paintSudoku(int depth) throws IOException {
        int row = empty[depth][0];
        int col = empty[depth][1];
        if (depth == count) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(sudoku[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            System.exit(0);
        }
        for (int i = 0; i < 9; i++) {
            if(check(i+1, row, col)) {  // 해당 empty 위치에 이런 값 넣어도 돼 ?
                sudoku[row][col] = i+1;
                paintSudoku(depth+1);
            } 
            sudoku[row][col] = 0;
        }
    }
    private static boolean check(int checkNum, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == checkNum)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == checkNum)
                return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(sudoku[(row/3)*3+i][(col/3)*3+j] == checkNum)
                    return false;
            }
        }
        return true;
    }
}


