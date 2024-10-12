import java.util.*;

class Solution {
    int[] size;
    int K;
    int N;
    int[][] arr;
    int result = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();
    
    public int solution(int k, int n, int[][] reqs) {
        K = k;
        N = n;
        arr = reqs;
        
        size = new int[k + 1];
        
        Arrays.fill(size, 1);
        
        dfs(K, 1);
        
        return result;
    }
    
    public void dfs(int sum, int idx){
//         StringBuilder sb = new StringBuilder();
        
//         for(int i = 1; i <= K; i++){
//             sb.append(size[i]);
//         }
        
//         if(!set.contains(sb.toString())){
//             set.add(sb.toString());
//         } else{
//             return;
//         }
        
        if(sum == N){
            Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
            
            int compute = 0;
            
            for(int i = 1; i <= K; i++){
                map.put(i, new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]));
            }
            
            for(int i = 0; i < arr.length; i++){
                int start = arr[i][0];
                int end = arr[i][1];
                int team = arr[i][2];
                
                if(map.get(team).size() >= size[team]){
                    if(map.get(team).peek()[1] <= start){
                        map.get(team).poll();
                        map.get(team).add(new int[]{start, start + end});
                    } else{
                        compute += (map.get(team).peek()[1] - start);
                        int num = map.get(team).poll()[1];
                        map.get(team).add(new int[]{start, num + end});
                    }
                } else if(map.get(team).size() < size[team]){
                    map.get(team).add(new int[]{start, start + end});
                }
                
                if(compute >= result){
                    return;
                }
            }
            
//             for(int i = 1; i <= K; i++){
//                 System.out.print(size[i] + " ");
//             }
//             System.out.println();
            
//             System.out.println(compute);
            result = Math.min(result, compute);
            
            return;
        }
        
        for(int i = idx; i <= K; i++){
            size[i] += 1;
            dfs(sum + 1, i);
            size[i] -= 1;
        }
    }
}