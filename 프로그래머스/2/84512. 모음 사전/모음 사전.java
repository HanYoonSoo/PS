import java.util.*;

class Solution {
    String[] arr = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        
//         for(String s : list){
//             System.out.println(s);
//         }
        return list.indexOf(word) + 1;
    }
    
    public void dfs(String str, int len){
        if(len == 5){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            String s = str.concat(arr[i]);
            list.add(s);
            dfs(s, len + 1);
        }
    }
}