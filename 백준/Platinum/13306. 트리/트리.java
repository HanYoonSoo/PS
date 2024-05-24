import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for(int i = 1; i <= N - 1; i++){
            int parentNum = Integer.parseInt(br.readLine());
            parent[i + 1] = parentNum;
        }

        int count = 0;
        for(int i = 1; i < N + Q; i++){
            if(count == Q)
                break;
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(checkParent(a, b)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
                count++;
            } else{
                int a = Integer.parseInt(st.nextToken());
                parent[a] = a;
            }
        }
    }

    private static boolean checkParent(int a, int b) {
        while(a != parent[a] && a != 1){
            a = parent[a];
        }

        while(b != parent[b] && b != 1){
            b = parent[b];
        }

        return a == b;
    }
}
//11 5
//7
//4
//1
//9
//11
//1
//11
//1
//3
//7