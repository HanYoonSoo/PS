import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int distance = Math.abs(-x) + Math.abs(-y);

            if(distance == count){
                System.out.println("YES");
            } else if(distance < count){
                if((count - distance) % 2 == 0){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            } else{
                System.out.println("NO");
            }
        }
    }
}
