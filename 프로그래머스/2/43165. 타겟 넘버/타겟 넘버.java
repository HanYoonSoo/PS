class Solution {
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int idx, int compute){
        if(numbers.length == idx ){
            if(compute == target){
                return 1;
            }
            return 0;
        }
        
        return dfs(numbers, target, idx + 1, compute + numbers[idx]) + dfs(numbers, target, idx + 1, compute - numbers[idx]);
    }
}

// class Solution {
//     public int solution(int[] numbers, int target) {
//         int answer = 0;
//         answer = dfs(numbers, 0, 0, target);
//         return answer;
//     }
//     int dfs(int[] numbers, int n, int sum, int target) {
//         if(n == numbers.length) {
//             if(sum == target) {
//                 return 1;
//             }
//             return 0;
//         }
//         return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
//     }
// }