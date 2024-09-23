import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        int count = 0;
        for(int i = 0; i < A.length; i++){
            boolean compare = false;
            for(int j = idx; j < B.length; j++){
                if(A[i] < B[j]){
                    idx = j + 1;
                    compare = true;
                    break;
                }
            }
            
            if(compare){
                count++;
            }
        }
        
        return count;
    }
}

// 1 3 5 7
// 2 2 6 8