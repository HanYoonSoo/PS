import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;
            while(x <= N && y <= N){
                if(x < y){
                    x += y;
                } else {
                    y += x;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}

//5
//1 2 2
//1 2 3
//1 2 4
//1 2 5
//10 7 1293