import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        
        for(int[] command : commands){
            // for(int i = 0; i < array.length; i++){
            //     System.out.print(array[i] + " ");
            // }
            // System.out.println();
            
            int[] arr = array.clone();
            
            Arrays.sort(arr, command[0] - 1, command[1]);
            
            // for(int i = 0; i < array.length; i++){
            //     System.out.print(arr[i] + " ");
            // }
            // System.out.println();
            
            answer[idx++] = arr[(command[0] - 1) + (command[2] - 1)];
        }
        
        return answer;
    }
}