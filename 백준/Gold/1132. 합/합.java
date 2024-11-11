import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Alpha{
        long point;
        boolean isFirst;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Alpha[] arr = new Alpha[10];

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < 10; i++){
            arr[i] = new Alpha();
        }

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            arr[str.charAt(0) - 'A'].point += Math.pow(10, str.length() - 1);
            arr[str.charAt(0) - 'A'].isFirst = true;

            for(int j = 1; j < str.length(); j++){
                arr[str.charAt(j) - 'A'].point += Math.pow(10, str.length() - j - 1);
            }
        }

        Arrays.sort(arr, (o1, o2) -> Long.compare(o1.point, o2.point));

        boolean[] visited = new boolean[10];

        long sum = 0;

        for(int i = 0; i < 10; i++){
            if(arr[i].isFirst){
                for(int j = 1; j <= 9; j++){
                    if(!visited[j]){
                        sum += arr[i].point * j;
                        visited[j] = true;
                        break;
                    }
                }
            } else{
                for(int j = 0; j <= 9; j++){
                    if(!visited[j]){
                        sum += arr[i].point * j;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
