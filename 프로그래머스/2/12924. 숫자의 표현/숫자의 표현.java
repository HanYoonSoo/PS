class Solution {
    public int solution(int n) {
        int count = 1;
        for(int i = 1; i <= n / 2 + 1; i++){
            int sum = i;
            for(int j = i + 1; j <= n / 2 + 1; j++){
                sum += j;
                if(sum == n)
                    count++;
                else if(sum > n){
                    break;
                }
            }
        }
        
        return count; 
    }
}