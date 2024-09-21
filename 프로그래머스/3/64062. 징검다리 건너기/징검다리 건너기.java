class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;
        
        // stones = new int[]{1, 1, 1};
        
        // if(stones.length())
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            // System.out.println(left + " " + mid + " " + right);
            
            int len = 1;
            int maxLen = 0;
            boolean flag = false;
            for(int i = 0; i < stones.length; i++){
                if(stones[i] - mid <= 0){
                    if(flag){
                        len++;
                    } else{
                        flag = true;
                    }
                    maxLen = Math.max(maxLen, len);
                } else{
                    flag = false;
                    len = 1;
                }
            }
            
            if(maxLen < k){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return left;
    }
}