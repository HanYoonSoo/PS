import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        //SYJKGW

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            Map<Long, Integer> team = new HashMap<>();

            for(int j = 0; j < count; j++){
                long num = Long.parseLong(st.nextToken());
                team.put(num, team.getOrDefault(num, 0) + 1);
            }

            boolean compare = false;
            for(long teamKey : team.keySet()){
                if(count / 2 + 1 <= team.get(teamKey)){
                    compare = true;
                    sb.append(teamKey).append("\n");
                    break;
                }
            }

            if(!compare){
                sb.append("SYJKGW").append("\n");
            }
        }

        System.out.println(sb);
    }
}
