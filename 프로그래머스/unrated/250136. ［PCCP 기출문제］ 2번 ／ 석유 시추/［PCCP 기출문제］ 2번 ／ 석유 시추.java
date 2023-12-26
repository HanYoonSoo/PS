import java.util.*;

class Solution {
    public int visited[][];
    public Map<Integer, List<Integer>> area_map = new HashMap<>();
    public Map<Integer, Integer> area_size = new HashMap<>();
    public int N;
    public int M;
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;

        visited = new int[N][M];

        int area = 1;
        
        for(int i = 0; i < M; i++){
            area_map.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 0 && land[i][j] == 1){
                    bfs(i, j, area, land);
                    area++;
                    
                    //System.out.println(i + " " + j);
                }
            }
        }


        int max = 0;

        for(int i = 0; i < M; i++){
            List<Integer> temp = area_map.get(i);
            if(temp != null) {
                int sum_size = 0;
                for (int j = 0; j < temp.size(); j++) {
                    sum_size += area_size.get(temp.get(j));
                }

                
                if (max < sum_size) {
                    max = sum_size;
                }
            }
        }
        return max;
    }
    
    public void bfs(int x, int y, int area, int[][] land){
        List<Integer> area_list = area_map.get(y);
        if(!area_list.contains(area))
            area_list.add(area);

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y));
        int size = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Node node = q.poll();
            int tx = node.x;
            int ty = node.y;
            size++;
            
            for(int i = 0; i < 4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0 || land[nx][ny] == 0)
                    continue;
                else{
                    visited[nx][ny] = area;
                    q.add(new Node(nx, ny));
                    if(ny != y){
                        List<Integer> area_temp = area_map.get(ny);
                        if(!area_temp.contains(area))
                            area_temp.add(area);
                        area_map.put(ny, area_temp);
                    }   
                }
            }
        }

        area_map.put(y, area_list);
        if(size != 1){
            size--;
        }
        area_size.put(area, size);
    }
}

class Node{
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}