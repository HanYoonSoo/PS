class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n + 1)/2];
        
        int[][] triangle = new int[n][n];
        
        int y = -1;
        int x = 0;
        
        int number = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    y++;
                } else if(i % 3 == 1){
                    x++;
                } else if(i % 3 == 2){
                    y--;
                    x--;
                }
                
                triangle[y][x] = number++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(triangle[i][j] == 0)
                    break;
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}