import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        Arrays.sort(arr, (o1, o2) -> Integer.valueOf(o1) - Integer.valueOf(o2));
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[0]).append(" ").append(arr[arr.length - 1]);
        
        return sb.toString();
    }
}