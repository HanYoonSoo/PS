class Solution {
    public int solution(int[] money) {
        int[] dpFirst = new int[money.length];
        int[] dpSecond = new int[money.length];
        
        dpFirst[0] = money[0];
        dpFirst[1] = money[0];
        
        dpSecond[0] = 0;
        dpSecond[1] = money[1];
        
        for(int i = 2; i < money.length; i++){
            dpFirst[i] = Math.max(dpFirst[i - 2] + money[i], dpFirst[i - 1]);
            dpSecond[i] = Math.max(dpSecond[i - 2] + money[i], dpSecond[i - 1]);
        }
        
        return Math.max(dpFirst[money.length - 2], dpSecond[money.length - 1]);
    }
}