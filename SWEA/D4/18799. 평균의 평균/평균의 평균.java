import java.util.*;
import java.io.*;

class Solution
{
    static boolean[] visited;
   	static int N;
    static int[] arr;
    static double avg;
    static int count;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                               
		int T;
		T= Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
            
            arr = new int[N];
            visited = new boolean[N];
            avg = 0;
            count = 0;
            
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
             }
            
            for(int i = 1; i <= N; i++){
            	dfs(0, 0, i);
            }
            
            if(avg % count != 0)
            	sb.append("#").append(test_case + " ").append(String.format("%.14f", avg / count)).append("\n");
            else
                sb.append("#").append(test_case + " ").append((int)avg / count).append("\n");
//            System.out.println(String.format("%.14f", avg / count));
		}
        
        System.out.println(sb);
	}
    
    public static void dfs(int idx, int cnt, int target){
    	if(cnt == target){
            double sum = 0;
        	for(int i = 0; i < N; i++){
            	if(visited[i]){
                	sum += arr[i];
                }
            }
            
            count++;
            avg += sum / target;
            
            return;
        }
        
        for(int i = idx; i < N; i++){
        	if(!visited[i]){
            	visited[i] = true;
                dfs(i + 1, cnt + 1, target);
                visited[i] = false;
            }
        }
    }
}
                                               