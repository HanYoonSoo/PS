import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        Map<String, Node> childs = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node root = new Node();

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            Node curr = root;

            for(int j = 0; j < count; j++){
                String s = st.nextToken();
                if(!curr.childs.containsKey(s)){
                    curr.childs.put(s, new Node());
                }
                curr = curr.childs.get(s);
            }
        }

        dfs(root, "");
    }

    public static void dfs(Node root, String depth){
        List<String> keys = new ArrayList<>(root.childs.keySet());
        Collections.sort(keys);

        for(String key : keys){
            System.out.println(depth + key);
            dfs(root.childs.get(key), depth + "--");
        }
    }
}
