import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] s;
    static boolean[] visited;
    static StringBuilder sb;  // 결과를 한 번에 출력하기 위한 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while (T-- > 0) {
            s = br.readLine().toCharArray();
            Arrays.sort(s); 
            visited = new boolean[s.length];
            dfs(new StringBuilder(), 0);
        }

        System.out.println(sb.toString());
    }

    public static void dfs(StringBuilder str, int depth) {
        if (depth == s.length) {
            sb.append(str).append('\n');
            return;
        }

        char lastUsed = '\0';
        for (int i = 0; i < s.length; i++) {
            if (!visited[i] && s[i] != lastUsed) {
                visited[i] = true;
                str.append(s[i]);
                dfs(str, depth + 1);
                str.deleteCharAt(str.length() - 1);
                visited[i] = false;
                lastUsed = s[i];
            }
        }
    }
}
