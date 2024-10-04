import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K1;
    static int K2;
    static int bY, bX;
    static int ans1 = Integer.MIN_VALUE;
    static int ans2 = Integer.MIN_VALUE;
    static boolean[] visited;
    static List<int[]> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K1 = Integer.parseInt(st.nextToken());
        K2 = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList<>();

        // 노드 좌표 입력 및 기지국 좌표 설정
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++){
                if(str[j].equals("B")){
                    bY = i;
                    bX = j;
                } else if(str[j].equals("N")){
                    nodeList.add(new int[]{i, j});
                }
            }
        }

        // 낮(K1)에 대한 DFS
        visited = new boolean[nodeList.size()];
        dfs(0, 0, M - K1, true);
        System.out.println(Math.max(ans1, 0));

        // 밤(K2)에 대한 DFS
        visited = new boolean[nodeList.size()];
        dfs(0, 0, K2, false);
        System.out.println(Math.max(ans2, 0));
    }

    // DFS 탐색 함수
    public static void dfs(int idx, int count, int K, boolean isDay){
        if(count == K){
            int sum = 0;
            int minY = Integer.MAX_VALUE;
            int maxY = -1;
            int minX = Integer.MAX_VALUE;
            int maxX = -1;

            for(int i = 0; i < nodeList.size(); i++){
                if((isDay && !visited[i]) || (!isDay && visited[i])) {
                    // 낮일 때는 선택되지 않은 노드들, 밤일 때는 선택된 노드들만 고려
                    sum += (Math.abs(bY - nodeList.get(i)[0]) + Math.abs(bX - nodeList.get(i)[1]));
                    minY = Math.min(minY, nodeList.get(i)[0]);
                    minX = Math.min(minX, nodeList.get(i)[1]);
                    maxY = Math.max(maxY, nodeList.get(i)[0]);
                    maxX = Math.max(maxX, nodeList.get(i)[1]);
                }
            }

            // 통신 성능 저하 계산
            int compute = sum - ((maxY - minY + 1) * (maxX - minX + 1));

            // 낮과 밤에 따라 다른 결과 저장
            if (isDay) {
                ans1 = Math.max(ans1, compute);
            } else {
                ans2 = Math.max(ans2, compute);
            }
            return;
        }

        // DFS 탐색
        for(int i = idx; i < nodeList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, count + 1, K, isDay);
                visited[i] = false;
            }
        }
    }
}
