import java.util.*;

class Solution {
     public static long solution(int n, int[] cores) {
         long left = 1L;
         long right = 500000001L;
         
         while(left <= right){
            long mid = (left + right) / 2;
             
            long sum = cores.length;
            for(int i = 0; i < cores.length; i++){
                sum += (mid / cores[i]);
            } 
            
             if(sum < n){
                 left = mid + 1;
             } else{
                 right = mid - 1;
             }
         }
         
         System.out.println(left);
         
         long total = cores.length;
         
         for(int i = 0; i < cores.length; i++){
             total += ((left - 1) / cores[i]);
             // System.out.println(total);
         }
         
         for(int i = 0; i < cores.length; i++){
             if(left % cores[i] == 0){
                 total++;
                 if(total == n){
                     return i + 1;
                 }
             }
         }
         
         return -1;
    }
}

// 0 - 1 2 3 - 3
// 1 - 1 - 4
// 2 - 1 2 - 6
