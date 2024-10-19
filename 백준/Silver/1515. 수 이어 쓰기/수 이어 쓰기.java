import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 1;
        String str = br.readLine();
        int idx = 0;
        while(num <= 30000){
            String n = String.valueOf(num);

            for(int i = 0; i < n.length(); i++){
                if(str.charAt(idx) == n.charAt(i)){
                    idx++;
                }
                if(idx == str.length()){
                    System.out.println(num);
                    System.exit(0);
                }
            }
            num++;
        }
    }
}
