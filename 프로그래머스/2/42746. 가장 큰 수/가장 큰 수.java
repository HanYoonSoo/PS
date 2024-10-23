import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // numbers = new int[]{1, 10, 100, 1000};
        String[] number = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            number[i] = String.valueOf(numbers[i]);    
        }
        
        Arrays.sort(number, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++){
            sb.append(number[i]);
        }
        
        String result = sb.toString();
        
        return result.startsWith("0") ? "0" : result;
    }
}

// 0215999108
// [1, 10, 100, 1000]
// 기댓값 〉 "1101001000"