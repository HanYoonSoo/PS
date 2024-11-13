import java.util.*;
import java.io.*;

class Solution {
    static int max;
	static StringBuilder sb;
    static int change;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder(st.nextToken());
            change = Integer.parseInt(st.nextToken());

            max = 0;
            
            change = Math.min(change, sb.length());
            
            dfs(0, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void dfs(int idx, int count) {
        if(count == change){
        	max = Math.max(max, Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int i = idx; i < sb.length(); i++){
        	for(int j = i + 1; j < sb.length(); j++){
            	char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                
                dfs(i, count + 1);
                
                temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
            }
        }
    }
}
