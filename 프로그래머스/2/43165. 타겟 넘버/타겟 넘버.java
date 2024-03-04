class Solution {
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 1, target, 0, 0, numbers.length);
        return result;
    }
    
    public void dfs(int[] numbers, int sign, int target, int idx, int compute, int length){
        if(length == idx ){
            if(compute == target){
                result++;
                return;
            }
            return;
        }
        
        dfs(numbers, sign, target, idx + 1, compute + sign * numbers[idx], length);
        dfs(numbers, sign, target, idx + 1, compute + (-sign * numbers[idx]), length);
    }
}