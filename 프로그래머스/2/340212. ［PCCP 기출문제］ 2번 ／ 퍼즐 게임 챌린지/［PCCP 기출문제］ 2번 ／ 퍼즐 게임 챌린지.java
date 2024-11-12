class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;
        
        for(int i = 0; i < diffs.length; i++){
            right = Math.max(right, diffs[i]);
        }
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            // System.out.println(left + " " + mid + " " + right);
            
            long sum = 0;
            
            for(int i = 0; i < diffs.length; i++){
                if(i > 0 && mid < diffs[i]){
                    sum += (times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];
                } else{
                    sum += times[i];
                }
            }
            
            if(sum <= limit){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}