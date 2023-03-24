import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] targetArr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] rags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String start = br.readLine();
        String target = br.readLine();

        boolean[] arrA = new boolean[N];
        boolean[] arrB = new boolean[N];
        targetArr = new boolean[N];

        for(int i = 0; i < N; i++){
            arrA[i] = start.charAt(i) == '0';
            arrB[i] = start.charAt(i) == '0';
            targetArr[i] = target.charAt(i) == '0';
        }

        dfs(1, 0, arrA);
        dfs(1, 1, turnOn(0, arrB));

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    public static void dfs(int idx, int count, boolean[] arr){
        if(idx == N){
            if(arr[idx - 1] == targetArr[idx-1]){
                result = Math.min(count, result);
            }
            return;
        }

        if(arr[idx - 1] != targetArr[idx - 1]){
            dfs(idx + 1, count + 1, turnOn(idx, arr));
        }
        else{
            dfs(idx + 1, count, arr);
        }
    }

    public static boolean[] turnOn(int idx, boolean[] arr){
        for(int i = idx - 1; i <= idx + 1; i++){
            if(i >=0 && i < N){
                arr[i] = !arr[i];
            }
        }

        return arr;
    }
}
