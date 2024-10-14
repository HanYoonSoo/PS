import java.util.*;

class Solution {
    int K;
    int N;
    int[][] arr;
    int result = Integer.MAX_VALUE;
    int[] sizes;
    public int solution(int k, int n, int[][] reqs) {
        K = k;
        N = n;
        arr = reqs;
        
        
        sizes = new int[K + 1];
        
        Arrays.fill(sizes, 1);
        
        dfs(1, K);
        
        return result;
    }
    
    public void dfs(int idx, int count){
        if(count == N){
            Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
            
            for(int i = 1; i <= K; i++){
                map.put(i, new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]));
            }
            
            int total = 0;
            
            // for(int i = 1; i <= K; i++){
            //     System.out.print(sizes[i] + " ");
            // }
            
            // System.out.println();
            
            for(int i = 0; i < arr.length; i++){
                int startTime = arr[i][0];
                int useTime = arr[i][1];
                int human = arr[i][2];
                
                if(map.get(human).size() < sizes[human]){
                    map.get(human).add(new int[]{startTime, startTime + useTime});
                } else{
                    int[] curr = map.get(human).poll();
                    
                    // System.out.println(curr[1]);
                    if(curr[1] <= startTime){
                        map.get(human).add(new int[]{startTime, startTime + useTime});
                    } else{
                        total += curr[1] - startTime;
                        map.get(human).add(new int[]{curr[1], curr[1] + useTime});
                    }
                }
            }
            
            // System.out.println(total);
            
            result = Math.min(result, total);
            
            return;
        }
        
        for(int i = idx; i <= K; i++){
            sizes[i]++;
            dfs(i, count + 1);
            sizes[i]--;
        }
    }
}