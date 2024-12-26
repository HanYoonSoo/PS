class Solution {
    int[] grid;
    int N;
    int answer = 0;
    public int solution(int n) {
        N = n;
        grid = new int[N];
        
        back(0);
        
        return answer;
    }
    
    public void back(int depth){
        if(depth == N){
            answer++;
            return;
        }
        
        for(int i = 0; i < N; i++){
            grid[depth] = i;
            if(isPossible(depth)){
                back(depth + 1);
            }
        }
    }
    
    public boolean isPossible(int i){
        for(int j = 0; j < i; j++){
            if(grid[i] == grid[j])
                return false;
            if(Math.abs(i - j) == Math.abs(grid[i] - grid[j]))
                return false;
        }
        
        return true;
    }
}