import java.util.*;

class Solution {
    Set<String> check;
    String[] u;
    String[] b;
    List<Set<String>> possible;
    int answer = 0;
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        u = user_id;
        b = banned_id;
        
        check = new HashSet<>();
        possible = new ArrayList<>();
        visited = new boolean[banned_id.length];
        
        for(String user : user_id){
            Set<String> temp = new HashSet<>();
            for(String ban : banned_id){
                boolean compare = false;
                if(user.length() != ban.length())
                    continue;
                else{
                    for(int i = 0; i < user.length(); i++){
                        if(ban.charAt(i) == '*')
                            continue;
                        else if(user.charAt(i) != ban.charAt(i)){
                            compare = true;
                            break;
                        }
                    }
                    
                    if(!compare){
                        temp.add(ban);
                    }
                }
            }
            possible.add(temp);
            // System.out.println(possible); 
        }
        
        dfs(0, new StringBuilder());
        
        return answer;

    }
    
    public void dfs(int depth, StringBuilder sb){
        // System.out.println(depth + " " + sb);
        if(depth == u.length){
            // System.out.println("1");
            for(int i = 0; i < b.length; i++){
                if(!visited[i]){
                    // System.out.println("123456");
                    return;
                }
            }
            
    
            
            if(!check.contains(sb.toString())){
                answer++;
                check.add(sb.toString());
            }
            
            return;
        }
        
        for(int i = 0; i < b.length; i++){
            if(!visited[i]){
                if(possible.get(depth).contains(b[i])){
                    visited[i] = true;
                    sb.append(depth);
                    dfs(depth + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }
        }
        
        dfs(depth + 1, sb);
    }
}