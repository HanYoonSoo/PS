class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s < n){
            return new int[]{-1};
        } else{
            for(int i = 0; i < n; i++){
                answer[i] = s / n;
            }
            
            for(int i = 0; i < s % n; i++){
                answer[n - i - 1]++;
            }
        }
        
        return answer;
    }
}