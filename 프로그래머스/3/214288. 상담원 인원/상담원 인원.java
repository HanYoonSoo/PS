import java.util.*;

class Solution {
    int[] sizes;
    int N;
    int K;
    int[][] arr;
    int result = Integer.MAX_VALUE;
    public int solution(int k, int n, int[][] reqs) {
        sizes = new int[k + 1];
        N = n;
        K = k;
        
        arr = reqs;
        
        Arrays.fill(sizes, 1);
        
        dfs(1, k);
        
        return result;
    }
    
    public void dfs(int idx, int k){
        if(k == N){
            Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
            
            for(int i = 1; i <= K; i++){
                map.put(i, new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]));
            }
            
            int total = 0;
            
            for(int i = 0; i < arr.length; i++){
                int startTime = arr[i][0];
                int useTime = arr[i][1];
                int type = arr[i][2];
                
                if(map.get(type).size() < sizes[type]){
                    map.get(type).add(new int[]{startTime + useTime});
                } else{
                    int[] prev = map.get(type).poll();
                    
                    if(prev[0] <= startTime){
                        map.get(type).add(new int[]{startTime + useTime});
                    } else{
                        total += prev[0] - startTime;
                        map.get(type).add(new int[]{prev[0] + useTime});
                    }
                }
            }
            
            result = Math.min(result, total);
            
            return;
        }
        
        for(int i = idx; i <= K; i++){
            sizes[i]++;
            dfs(i, k + 1);
            sizes[i]--;
        }
    }
}