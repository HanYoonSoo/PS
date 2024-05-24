import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger bigInteger = BigInteger.ONE;

        for(int i = N; i >= 1; i--){
            bigInteger = bigInteger.multiply(new BigInteger("" + i));
//            System.out.println(bigInteger);
        }

        while(bigInteger.compareTo(BigInteger.valueOf(10)) >= 1){
            String str = bigInteger.toString();
            long sum = 0;
            for(int i = 0; i < str.length(); i++){
                sum += str.charAt(i) - '0';
            }
            bigInteger = BigInteger.valueOf(sum);
        }

        System.out.println(bigInteger);
    }
}
