import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");

        int prev = Integer.parseInt(num[0]);
        int curr = 0;

        boolean compare = true;

        for(int i = 1; i < num.length; i++){
            curr = Integer.parseInt(num[i]);
            if((prev - curr) == -1){
                compare = true;
            } else if((prev - curr) != -1 && (prev - curr) != 1){
                System.out.println("mixed");
                return;
            }
            else {
                compare = false;
            }

            prev = curr;
        }

        if(compare){
            System.out.println("ascending");
        } else{
            System.out.println("descending");
        }
    }
}
