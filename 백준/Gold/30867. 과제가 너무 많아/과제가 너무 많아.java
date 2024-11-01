import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        int l = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        
        StringBuilder s = new StringBuilder(br.readLine());

        int cnt = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'w') {
                cnt++;
            } else if (s.charAt(i) == 'h') {
                cnt = Math.min(cnt, n);
                s.setCharAt(i, 'w');
                s.setCharAt(i - cnt, 'h');
            } else {
                cnt = 0;
            }
        }
        
        System.out.println(s);
    }
}
