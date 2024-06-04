class Solution {
    public int solution(String[] board) {
        // board = new String[]{"XXX", "XOO", "OOO"} ; 
        String[][] board_Arr = new String[3][3];
        
        for(int i = 0; i < 3; i++){
            board_Arr[i] = board[i].split("");
        }
        int o = 0;
        int x = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board_Arr[i][j].equals("O")){
                    o++;
                } else if(board_Arr[i][j].equals("X")){
                    x++;
                }
            }
        }
        
        if(o < x || Math.abs(o - x) >= 2){
            return 0;
        }
        
        boolean check = false;
        boolean oWin = false;
        boolean xWin = false;
        
        for(int i = 0; i < 3; i++){
            if(board_Arr[i][0].equals(board_Arr[i][1]) && board_Arr[i][1].equals(board_Arr[i][2])){
                check = true;
                if(board_Arr[i][0].equals("X")){
                    xWin = true;
                } else if(board_Arr[i][0].equals("O")){
                    oWin = true;
                }
            }
            else if(board_Arr[0][i].equals(board_Arr[1][i]) && board_Arr[1][i].equals(board_Arr[2][i])){
                check = true;
                if(board_Arr[0][i].equals("X")){
                    xWin = true;
                } else if(board_Arr[0][i].equals("O")){
                    oWin = true;
                }
            }
        }
        
        if(check){
            if(xWin && oWin)
                return 0;
            else if(oWin){
                if(Math.abs(o - x) == 0)
                    return 0;
            } else if(xWin){
                if(o > x){
                    return 0;
                }
            }
        }
        
        if(board_Arr[0][0].equals(board_Arr[1][1]) && board_Arr[1][1].equals(board_Arr[2][2])){
            check = true;
            if(board_Arr[0][0].equals("X")){
                    xWin = true;
                } else if(board_Arr[0][0].equals("O")){
                    oWin = true;
                }
        }
        else if(board_Arr[0][2].equals(board_Arr[1][1]) && board_Arr[1][1].equals(board_Arr[2][0])){
            check = true;
            if(board_Arr[0][2].equals("X")){
                    xWin = true;
                } else if(board_Arr[0][2].equals("O")){
                    oWin = true;
                }
        }
        
        if(check){
           if(xWin && oWin)
                return 0;
            else if(oWin){
                if(Math.abs(o - x) == 0)
                    return 0;
            } else if(xWin){
                if(o > x){
                    return 0;
                }
            }
        }
        
        return 1;
    }
}

// OXX
// OXX
// OOO

// OOO
// OXX
// OXX

// OXX
// OOO
// OXX

// 개수 먼저 파악
// O가 승자일 때 X가 O와 수가 같으면 실패
// X가 승자일 때 O가 X보다 많으면 실패

