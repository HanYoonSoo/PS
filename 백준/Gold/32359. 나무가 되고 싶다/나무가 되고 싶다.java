import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static long max = (1L << 60) - 1;
    static int result = 0;
    static Set<Long> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            long num = Long.parseLong(st.nextToken());

            set.add(num);
        }

        if(checkTree(1L)){
            System.out.println(result);
        } else{
            System.out.println(-1);
        }

    }

    public static boolean checkTree(long root){
        if(set.contains(root)){
            return true;
        }

        result++;

        if(root > max){
            return false;
        }

        if(!checkTree(root * 2)){
            return false;
        }

        if(!checkTree(root * 2 + 1)){
            return false;
        }

        return true;
    }
}
//100000000