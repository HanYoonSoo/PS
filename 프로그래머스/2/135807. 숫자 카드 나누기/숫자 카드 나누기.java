import java.util.*;

class Solution {
    public boolean isDivide(int[] arr, int compare){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % compare != 0){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isNotDivide(int[] arr, int compare){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % compare == 0){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int length = arrayA.length;
        
        int max = Math.max(arrayA[0], arrayB[0]);
        for(int i = 2; i <= max; i++){
            if((isDivide(arrayA, i) && isNotDivide(arrayB, i)) || 
                (isDivide(arrayB, i) && isNotDivide(arrayA, i))){
                answer = i;
            }
        }
        
        return answer;
    }
}

