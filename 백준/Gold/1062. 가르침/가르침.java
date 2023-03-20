import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visited;

    static int maxValue = Integer.MIN_VALUE;

    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        words = new String[N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");

            words[i] = str;
        }

        if(K < 5){
            System.out.println("0");
            return;
        }
        else if(K == 26){
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        bactracking(0, 0);

        System.out.println(maxValue);
    }

    public static void bactracking(int idx, int depth){
        if(depth == K - 5){
            int count = 0;

            for(int i = 0; i < N; i++){
                boolean read = true;
                for(int j = 0; j < words[i].length(); j++){
                    if(!visited[words[i].charAt(j) - 'a']){
                        read = false;
                        break;
                    }
                }
                if(read){
                    count++;
                }
            }

            maxValue = Math.max(maxValue, count);

            return;
        }

        for(int i = idx; i < 26; i++){
            if(!visited[i]){
                visited[i] = true;
                bactracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
