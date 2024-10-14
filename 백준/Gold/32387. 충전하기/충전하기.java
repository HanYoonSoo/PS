import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> setPorts = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            setPorts.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int port = Integer.parseInt(st.nextToken());

            if (command == 1) {
                // 주어진 포트 번호 이상의 사용 가능한 포트를 찾음
                Integer assignedPort = setPorts.ceiling(port);
                
                if (assignedPort == null) {
                    sb.append(-1).append("\n");
                } else {
                    map.put(assignedPort, i);
                    setPorts.remove(assignedPort);
                    sb.append(assignedPort).append("\n");
                }
            } else {
                if (map.containsKey(port)) {
                    sb.append(map.get(port)).append("\n");
                    map.remove(port);
                    setPorts.add(port);
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
