class Solution {
    int N, M;
    int[][] sum;
    public int solution(int[][] board, int[][] skills) {
        N = board.length;
        M = board[0].length;
        
        sum = new int[N + 1][M + 1];
        
        for(int[] skill : skills){
            int type = skill[0];
            int y1 = skill[1];
            int x1 = skill[2];
            int y2 = skill[3];
            int x2 = skill[4];
            int power = skill[5];
            
            power = power * (type == 1 ? -1 : 1);
            
            sum[y1][x1] += power;
            sum[y1][x2 + 1] -= power;
            sum[y2 + 1][x1] -= power;
            sum[y2 + 1][x2 + 1] += power;
        }
        
        for(int i = 0; i <= N; i++){
            for(int j = 1; j <= M; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        
        for(int j = 0; j <= M; j++){
            for(int i = 1; i <= N; i++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if((board[i][j] + sum[i][j]) > 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}