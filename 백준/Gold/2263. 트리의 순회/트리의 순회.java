import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] inorder;
    static int[] postorder;
    static int[] nodeIdx;

    public static void dfs(int inStart, int inEnd, int postStart, int postEnd){
        if((inStart > inEnd) || (postStart > postEnd)){
            return;
        }

        int root = postorder[postEnd];

        int leftNode = nodeIdx[root] - inStart;
        int rightNode = inEnd - nodeIdx[root];

        System.out.print(root + " ");
        dfs(inStart, inStart + leftNode - 1, postStart, postStart + leftNode - 1);
        dfs(inEnd - rightNode + 1, inEnd, postEnd - rightNode, postEnd - 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        postorder = new int[N];
        nodeIdx = new int[N + 1];

        String[] in = br.readLine().split(" ");
        String[] post = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            inorder[i] = Integer.parseInt(in[i]);
            postorder[i] = Integer.parseInt(post[i]);
            nodeIdx[inorder[i]] = i;
        }

        dfs(0, N - 1, 0, N - 1);

    }
}
