import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    static int N, M;
    static int[] parent;
    static HashSet<Integer> tree;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = 1;

        while(true){
            String[] temp = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);

            if(N == 0 && M == 0){
                break;
            }

            parent = new int[N + 1];
            tree = new HashSet<>();

            for(int i = 0; i <= N; i++){
                parent[i] = i;
            }

            for(int i = 0; i < M; i++){
                temp = br.readLine().split(" ");

                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);

                union(a, b);
            }


            for(int i = 1; i <= N; i++){
                int p = find_parent(i);
                if(p > 0){
                    tree.add(p);
                }
            }

            int result = tree.size();

            if(result == 1){
                System.out.println("Case "+cases+": There is one tree.");
            }
            else if(result >= 2){
                System.out.println("Case "+cases+": A forest of " + result + " trees.");
            }
            else{
                System.out.println("Case "+cases+": No trees.");
            }
            cases++;
        }

    }

    public static int find_parent(int p) {
        if(parent[p] == p){
            return p;
        }

        parent[p] = find_parent(parent[p]);

        return parent[p];
    }

    public static void union(int a, int b){
        int parent_a = find_parent(a);
        int parent_b = find_parent(b);

        if(parent_a == parent_b){
            parent[parent_b] = parent_a;
            parent[parent_a] = 0;
        }
        else if(parent_a < parent_b){
            parent[parent_b] = parent_a;
        }
        else{
            parent[parent_a] = parent_b;
        }

    }
}
