import java.util.*;

public class Main {
    static class Point {
        int x;
        int count;
        Point(int x, int count){
            this.x=x;
            this.count=count;
        }
    }
    static int n,m;
    static int answer =Integer.MAX_VALUE;
    static boolean []board;
    static void bfs(int start, int end){
        Queue<Point>q=new LinkedList<>();
        q.add(new Point(start,0));
        board[start]=true;
        while(!q.isEmpty()){
            Point frog=q.poll();
            int x = frog.x;
            int count = frog.count;
            if(x==end){
                answer = Math.min(answer,count);
            }
            if(2*x<=100000 && !board[2*x]){
                board[2*x]=true;
                q.add(new Point(2*x,count));
            }
            if(x-1>=0 && !board[x-1]){
                board[x-1]=true;
                q.add(new Point(x-1,count+1));
            }
            if(x+1<=100000 && !board[x+1]){
                board[x+1]=true;
                q.add(new Point(x+1,count+1));
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new boolean [100001];
        bfs(n,m);
        System.out.println(answer);
    }
}