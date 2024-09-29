import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();

            if(s.equals("end")){
                System.out.println(sb);
                break;
            }

            board = new char[3][3];

            int oCount = 0;
            int xCount = 0;

            for(int i = 0; i < 9; i++){
                int r = i / 3;
                int c = i % 3;

                board[r][c] = s.charAt(i);

                if(board[r][c] == 'O'){
                    oCount++;
                } else if(board[r][c] == 'X'){
                    xCount++;
                }
            }

//            for(int i = 0; i < 3; i++){
//                for(int j = 0; j < 3; j++){
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("==============");

            if(xCount == oCount + 1){
                if(xCount + oCount == 9 && !check('O')){
                    sb.append("valid").append("\n");
                } else if(!check('O') && check('X')){
                    sb.append("valid").append("\n");
                } else{
                    sb.append("invalid").append("\n");
                }
            } else if(xCount == oCount){
                if(!check('X') && check('O')){
                    sb.append("valid").append("\n");
                } else{
                    sb.append("invalid").append("\n");
                }
            } else{
                sb.append("invalid").append("\n");
            }
        }
    }

    public static boolean check(char c){
        // 가로
        for(int i = 0; i < 3; i++){
            if(board[i][0] == c && board[i][1] == c && board[i][2] == c){
                return true;
            }
        }

        // 세로
        for(int i = 0; i < 3; i++){
            if(board[0][i] == c && board[1][i] == c && board[2][i] == c){
                return true;
            }
        }

        // 대각선
        if(c == board[0][0] && c == board[1][1] && c == board[2][2]){
            return true;
        }

        if(c == board[0][2] && c == board[1][1] && c == board[2][0]){
            return true;
        }

        return false;
    }
}
