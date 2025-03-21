class Solution {
    public int[] solution(String s) {
        int count = 0;
        int size = 0;
        
        while(!s.equals("1")){
            int zeroCount = 0;
            int oneCount = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            
            count++;
            size += zeroCount;
            s = Integer.toBinaryString(oneCount);
        }
        
        return new int[]{count, size};
    }
}