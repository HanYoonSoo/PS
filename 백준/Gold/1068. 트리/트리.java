import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<List<Integer>> tree;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        int root = -1;

        int remove_node = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1 && i != remove_node) {
                tree.get(arr[i]).add(i);
            } else if (arr[i] == -1 && i != remove_node) {
                root = i;
            }
        }

        tree.set(remove_node, new ArrayList<>());

        if (root != -1) {
            dfs(root);
        }
        System.out.println(count);
    }

    private static void dfs(int start) {
        if (tree.get(start).isEmpty()) {
            count++;
            return;
        }

        for (int v : tree.get(start)) {
            dfs(v);
        }
    }
}
