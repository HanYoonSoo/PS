class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            System.out.println(left + " " + mid + " " + right);
            int len = 0;
            int maxLen = 0;
            for(int i = 0; i < stones.length; i++){
                if(stones[i] - mid <= 0){
                    len++;
                } else{
                    maxLen = Math.max(maxLen, len);
                    len = 0;
                }
            }
            
            System.out.println("maxLen " + maxLen);
            if(maxLen < k){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        
        System.out.println(left);
        return left;
    }
}