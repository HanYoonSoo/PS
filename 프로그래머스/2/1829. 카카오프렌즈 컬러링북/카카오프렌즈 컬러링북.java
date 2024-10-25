import java.util.*;
class Solution {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int M,N;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int maxSizeOfOneArea, numberOfArea, count;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        M=m;
        N=n;
        maxSizeOfOneArea = Integer.MIN_VALUE;
        numberOfArea = 0;
        count = 0;
        arr = new int[M][N];
        visit = new boolean[M][N];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = picture[i][j];
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j] && arr[i][j]!=0){
                    numberOfArea++;
                    count =0;
                    dfs(i,j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,count);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void dfs(int r, int c){
        visit[r][c] = true;
        count++;

        for(int i=0; i<4; i++){
            int nx = r+dx[i];
            int ny = c+dy[i];
            if(nx>=0 && ny>=0 && nx<M && ny<N){
                if(!visit[nx][ny] && arr[nx][ny]!=0 && arr[nx][ny] == arr[r][c]){
                    dfs(nx,ny);
                }
            }
        }
    }
}