import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> trashes = new TreeSet<>();

        StringTokenizer st;

        long total = 0;

        int currX = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if(command == 1){
                int x = Integer.parseInt(st.nextToken());
                trashes.add(x);
            } else{
                while(!trashes.isEmpty()){
                    Integer left = trashes.floor(currX);
                    Integer right = trashes.ceiling(currX);

                    int nextX;
                    if(left == null){
                        nextX = right;
                    } else if(right == null){
                        nextX = left;
                    } else if(Math.abs(left - currX) <= Math.abs(right - currX)){
                        nextX = left;
                    } else{
                        nextX = right;
                    }

                    total += Math.abs(nextX - currX);
                    currX = nextX;
                    trashes.remove(nextX);
                }
            }
        }
        System.out.println(total);
    }
}
