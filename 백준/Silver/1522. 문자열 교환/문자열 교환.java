import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int aCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a')
                aCount++;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            int bCount = 0;
            for(int j = i; j < i + aCount; j++){
                if(s.charAt(j % s.length()) == 'b')
                    bCount++;
            }

            min = Math.min(bCount, min);
        }

        System.out.println(min);
    }
}
