class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int compare = storey % 10;
            storey /= 10;
            
            if(compare == 5){
                if(storey % 10 >= 5){
                    answer += 10 - compare;
                    storey++;
                } else{
                    answer += compare;
                }
            } else if(compare > 5){
                answer += 10 - compare;
                storey++;
            } else{
                answer += compare;
            }
        }
        
        return answer;
    }
}