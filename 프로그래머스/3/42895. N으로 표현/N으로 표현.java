import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for(int i = 2; i <= 8; i++){
            String num = String.valueOf(N).repeat(i);
            
            dp.get(i).add(Integer.valueOf(num));
            
            for(int j = 1; j < i; j++){
                int k = i - j;
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(k)){
                        dp.get(i).add(num1 * num2);
                        
                        if(num1 + num2 > 0){
                            dp.get(i).add(num1 + num2);
                        }
                        
                        if(num1 - num2 > 0){
                            dp.get(i).add(num1 - num2);
                        }
                        
                        if(num2 != 0){
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i <= 8; i++){
            if(dp.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
}