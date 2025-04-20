import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] org;
    static int[] arr;
    static int[] P;
    static int[] S;
    public static void main(String[] args) throws IOException {
        // 최종: 2 0 1
        // 변경: 1 2 0
        // 0 1 2
        // 2 0 1
        // 1 2 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        org = new int[N];
        arr = new int[N];

        for(int i = 0; i < N; i++){
            org[i] = i;
            arr[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        P = new int[N];
        S = new int[N];

        boolean compare = true;
        for(int i = 0; i < N; i++){
            P[i] = Integer.parseInt(st.nextToken());
            if(i % 3 != P[i]){
                compare = false;
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        if(compare){
            System.out.println(0);
            return;
        }

        int count = 0;

        Set<String> set = new HashSet<>();

        while(true){
            int[] temp = new int[N];
            for(int i = 0; i < N; i++){
                temp[S[i]] = arr[i];
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < N; i++){
                sb.append(temp[i]);
            }

            if(set.contains(sb.toString())){
                System.out.println("-1");
                return;
            } else {
                set.add(sb.toString());
            }

            if(compare(temp)){
                System.out.println(count + 1);
                return;
            }
            arr = temp;
            count++;
        }
    }

    public static boolean compare(int[] temp){
        for(int i = 0; i < N; i++){
//            System.out.println(P[temp[i]] + " " + org[i]);
            if(P[temp[i]] != i % 3){
                return false;
            }
        }

        return true;
    }
}
//6
//0 1 2 0 1 2
//1 4 0 3 2 5

//0 1 2 3 4 5
//2 0 4 3 1 5
