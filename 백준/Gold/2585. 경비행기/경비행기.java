import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int x;
        int y;
        int count;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int N;
    static int K;
    static Point[] pointArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pointArr = new Point[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointArr[i] = new Point(x, y);
        }

        int left = 0;
        int right = 1500;

        while(left <= right){
            int mid = (left + right) / 2;
            visited = new boolean[N];
            if(bfs(mid)){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    public static boolean bfs(int fuel){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));

        while(!q.isEmpty()){
            Point curr = q.poll();


            if(curr.count > K){
                continue;
            }

            if(fuel >= compute(curr.x, curr.y, 10000, 10000)){
                return true;
            }

            for(int i = 0; i < N; i++){
                if(!visited[i] && fuel >= compute(curr.x, curr.y, pointArr[i].x, pointArr[i].y)){
                    visited[i] = true;
                    q.add(new Point(pointArr[i].x, pointArr[i].y, curr.count + 1));
                }
            }
        }

        return false;
    }

    public static int compute(int currX, int currY, int targetX, int targetY){
        return (int) Math.ceil(Math.sqrt(Math.pow(targetX - currX, 2) + Math.pow(targetY - currY, 2)) / 10.0);
    }
}
