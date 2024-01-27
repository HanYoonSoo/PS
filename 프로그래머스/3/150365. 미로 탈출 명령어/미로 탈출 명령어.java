import java.util.LinkedList;
import java.util.Queue;

/**
 * n x m (x, y) -k-> (r, c)
 */
class Solution {
    static int n;
    static int m;
    static int x;
    static int y;
    static int r;
    static int c;
    static int k;
    static String grid[][];
    static int visited[][];

    public String solution(int n1, int m1, int x1, int y1, int r1, int c1, int k1) {
        n = n1;
        m = m1;
        x = x1;
        y = y1;
        r = r1;
        c = c1;
        k = k1;

        int distance = Math.abs(x - r) + Math.abs(y - c);

        // 거리가 안되면 "impossible" 출력
        // (1, 1) -> (6, 1) 인데 k가 4인 경우
        if(distance > k){
            return "impossible";
        }

        // 거리는 되지만 도착지에 도달할 수 없는 경우
        // (1, 1) -> (2, 1)로 갈 때 k가 4인 경우 3의 거리를 가야되는데 나머지 2 했을 때 0이 나오지 않으면 갈 수 없음
        if((distance - k) % 2 != 0){
            return "impossible";
        }

        grid = new String[n+1][m+1];
        visited = new int[n+1][m+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == x && j == y){
                    grid[i][j] = "S";
                }
                else if(i == r && j == c){
                    grid[i][j] = "E";
                }
                else{
                    grid[i][j] = ".";
                }
            }
        }

        String result = bfs(x, y);
        return result;
    }

    private static String bfs(int a, int b) {
        // 알파벳의 우선 순위가 높은 순(사전 순)으로 탐색 진행
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        String[] move = {"d", "l", "r", "u"};

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(a, b, ""));

        // bfs 반복문 시작
        while(!q.isEmpty()){
            Node curr = q.poll();

            int x = curr.x;
            int y = curr.y;
            String cur_str = curr.result;

            // k만큼 이동하고 도착지라면 반환
            if(visited[x][y] == k && x == r && y == c){
                return curr.result;
            }
            else if(visited[x][y] > k){
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(1 <= nx && nx <= n && 1 <= ny && ny <= m){
                    if(Math.abs(nx - r) + Math.abs(ny - c) + visited[x][y] + 1 > k)
                        continue;
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new Node(nx, ny, cur_str.concat(move[i])));
                    break;
                }
            }
        }
        return "";
    }

    static class Node{
        int x;
        int y;
        String result;

        public Node(int x, int y, String result) {
            this.x = x;
            this.y = y;
            this.result = result;
        }
    }
}
