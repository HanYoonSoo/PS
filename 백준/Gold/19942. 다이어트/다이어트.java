import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int minDan = Integer.parseInt(st.nextToken());
        int minFat = Integer.parseInt(st.nextToken());
        int minTan = Integer.parseInt(st.nextToken());
        int minVit = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][5];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
            arr[i][4] = Integer.parseInt(st.nextToken());
        }

        int max = (1 << N);

        int minCost = Integer.MAX_VALUE;
        String resultSet = "-1";

        for(int i = 0; i < max; i++){
            int sumDan = 0;
            int sumFat = 0;
            int sumTan = 0;
            int sumVit = 0;
            int sumCost = 0;

            StringBuilder set = new StringBuilder();
            for(int j = 0; j < N; j++){
                if((i & (1 << j)) != 0){
                    sumDan += arr[j][0];
                    sumFat += arr[j][1];
                    sumTan += arr[j][2];
                    sumVit += arr[j][3];
                    sumCost += arr[j][4];

                    set.append((j + 1)).append(" ");
                }

            }

            if(minDan <= sumDan && minFat <= sumFat && minTan <= sumTan && minVit <= sumVit){
                if(minCost >= sumCost){
                    if(minCost == sumCost){
                        if(resultSet.compareTo(set.toString()) > 0){
                            resultSet = set.toString();
                        }
                    } else{
                        minCost = sumCost;
                        resultSet = set.toString();
                    }
                }
            }
        }

        if(minCost == Integer.MAX_VALUE){
            System.out.println(resultSet);
        } else{
            System.out.println(minCost);
            System.out.println(resultSet);
        }
    }
}
