import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int friends = Integer.parseInt(br.readLine());

            parent = new int[friends * 2];
            size = new int[friends * 2];

            Map<String, Integer> nameMap = new HashMap<>();

            for (int i = 0; i < friends * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            int idx = 0;

            StringTokenizer st;
            for (int i = 0; i < friends; i++ ) {
                st = new StringTokenizer(br.readLine());

                String left = st.nextToken();
                String right = st.nextToken();

                int leftIdx;
                int rightIdx;

                if (!nameMap.containsKey(left)) {
                    nameMap.put(left, idx);
                    leftIdx = idx;
                    idx++;
                } else {
                    leftIdx = nameMap.get(left);
                }

                if (!nameMap.containsKey(right)) {
                    nameMap.put(right, idx);
                    rightIdx = idx;
                    idx++;
                } else {
                    rightIdx = nameMap.get(right);
                }
                
                System.out.println(union(leftIdx, rightIdx));
            }
        }
    }

    public static int find_parent(int p) {
        if (p == parent[p]) {
            return p;
        }

        parent[p] = find_parent(parent[p]);

        return parent[p];
    }

    public static int union(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);

        if (a == b) {
            return size[a];
        }

        if (a < b) {
            parent[b] = a;
            size[a] += size[b];
            return size[a];
        } else {
            parent[a] = b;
            size[b] += size[a];
            return size[b];
        }
    }
}
