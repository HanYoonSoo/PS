import java.util.*;

class Solution {
    
    Map<Integer, Set<Integer>> xLandMap = new HashMap<>();
    Map<Integer, Integer> landSizeMap = new HashMap<>();
    boolean[][] visited;
    int N, M;
    int[][] landArr;
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        landArr = land;
        visited = new boolean[N][M];
        
        for (int i = 0; i < M; i++) {
            xLandMap.put(i, new HashSet<>());
        }
        
        int landCount = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (landArr[i][j] == 1 && !visited[i][j]) {
                    xLandMap.get(j).add(landCount);
                    int size = bfs(i, j, landCount);
                    landSizeMap.put(landCount, size);
                    landCount++;
                }
            }
        }
        
        int max = 0;
        
        for (int x : xLandMap.keySet()) {
            int total = 0;
            for (int l : xLandMap.get(x)) {
                total += landSizeMap.get(l);
            }
            max = Math.max(total, max);
        }
        
        // System.out.println(landSizeMap);
        
        return max;
        
    }
    
    public int bfs(int y, int x, int landCount) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        q.add(new int[]{y, x});
        visited[y][x] = true;
        
        int size = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (landArr[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        size++;
                        q.add(new int[]{ny, nx});
                        xLandMap.get(nx).add(landCount);
                    }
                }
            }
        }
        
        return size;
    }
}