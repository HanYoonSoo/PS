import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int[] dp = new int[num.length() + 1];

        if(num.charAt(0) == '0'){
            System.out.println(0);
            return;
        }

        dp[0] = dp[1] = 1;

        for(int i = 2; i <= num.length(); i++){
            int il = num.charAt(i - 1) - '0';
            int sib = (num.charAt(i - 2) - '0') * 10 + il;

            if(il >= 1){
                dp[i] = dp[i - 1];
            }

            if(sib >= 10 && sib <= 26){
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }

        System.out.println(dp[num.length()]);
    }
}
