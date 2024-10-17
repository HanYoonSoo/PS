import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        int S = 0;
        int T = 0;
        int maxLength = 0;

        for(int i = 0; i < N - 1; i++){
            String tempS = arr[i];
            for(int j = i + 1; j < N; j++){
                String tempT = arr[j];

                int minLen = Math.min(tempS.length(), tempT.length());

                int count = 0;
                for(int k = 0; k < minLen; k++){
                    if(tempS.charAt(k) == tempT.charAt(k)){
                        count++;
                    } else{
                        break;
                    }
                }

                if(count > maxLength){
                    maxLength = count;
                    S = i;
                    T = j;
                }
            }
        }

        System.out.println(arr[S]);
        System.out.println(arr[T]);
    }
}
