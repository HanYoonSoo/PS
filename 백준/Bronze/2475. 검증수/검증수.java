import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");

        int result = 0;
        for(String s : num){
            result += Integer.parseInt(s) * Integer.parseInt(s);
        }

        System.out.println(result % 10);
    }
}
