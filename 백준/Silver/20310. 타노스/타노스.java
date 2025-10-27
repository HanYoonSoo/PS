import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numArr = br.readLine().split("");

        int oneCount = 0;
        int zeroCount = 0;

        for(int i = 0; i < numArr.length; i++){
            if(numArr[i].equals("0")){
                zeroCount++;
            } else{
                oneCount++;
            }
        }

        oneCount /= 2;
        zeroCount /= 2;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < zeroCount; i++){
            sb.append("0");
        }

        for(int i = 0; i < oneCount; i++){
            sb.append("1");
        }

        System.out.println(sb);
    }
}
