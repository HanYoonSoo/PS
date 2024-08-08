import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int[] parent = new int[N + 1];

            Arrays.fill(parent, 0);

            StringTokenizer st;
            for(int i = 0; i < N - 1; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());

            int child1 = Integer.parseInt(st.nextToken());
            int child2 = Integer.parseInt(st.nextToken());

            List<Integer> aParent = new ArrayList<>();
            List<Integer> bParent = new ArrayList<>();

            aParent.add(child1);
            bParent.add(child2);

            while(parent[child1] != 0){
                aParent.add(parent[child1]);
                child1 = parent[child1];
            }

            while(parent[child2] != 0){
                bParent.add(parent[child2]);
                child2 = parent[child2];
            }


            int aLength = aParent.size() - 1;
            int bLength = bParent.size() - 1;

            while(aLength >= 0 && bLength >= 0 && (aParent.get(aLength).equals(bParent.get(bLength)))){
//                System.out.println(aParent.get(aLength) + " " + bParent.get(bLength));
                aLength--;
                bLength--;
            }

            System.out.println(aParent.get(aLength + 1));
        }
    }
}
