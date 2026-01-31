class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            right = Math.max(right, diffs[i]);
        }
        
        while (left <= right) {
            long level = (left + right) / 2;
            
            long totalTime = times[0];
            
            for (int i = 1; i < diffs.length; i++) {
                if (level >= diffs[i]) {
                    totalTime += times[i];
                } else {
                    totalTime += (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
                }
            }
            
            if (totalTime <= limit) {
                right = level - 1;
            } else {
                left = level + 1;
            }
        }
        
        return left;
    }
}