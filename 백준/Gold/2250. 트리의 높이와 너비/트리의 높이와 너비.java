import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int parent;
        int num;
        int leftChild;
        int rightChild;

        public Node(int num, int leftChild, int rightChild){
            this.parent = -1;
            this.num = num;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    // 각 열에 들어가 있는 노드를 구하기 위한 배열
    // 자식노드의 갯수를 새서 그 만큼 열 사용
    static Node[] nTree;
    static int[] levelMin;
    static int[] levelMax;
    static int curIdx = 1;
    static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        nTree = new Node[N + 1];
        levelMin = new int[N + 1];
        levelMax = new int[N + 1];

        for(int i = 1; i <= N; i++){
            nTree[i] = new Node(i, -1, -1);
            levelMin[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int root = Integer.parseInt(st.nextToken());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());

            nTree[root].leftChild = leftChild;
            nTree[root].rightChild = rightChild;

            if(leftChild != -1){
                nTree[leftChild].parent = root;
            }

            if(rightChild != -1){
                nTree[rightChild].parent = root;
            }
        }

        int root = 0;
        for(int i = 1; i <= N; i++){
            if(nTree[i].parent == -1){
                root = nTree[i].num;
            }
        }

        inOrder(root, 1);

        int maxLevel = Integer.MAX_VALUE;
        int maxLength = 0;

        for(int i = 1; i <= maxDepth; i++){
            if(maxLength < (levelMax[i] - levelMin[i] + 1)){
                maxLength = (levelMax[i] - levelMin[i] + 1);
                maxLevel = i;
            }

//            System.out.println(i + " " + levelMin[i] + " " + levelMax[i]);
        }

        System.out.println(maxLevel + " " + maxLength);
    }

    public static void inOrder(int root, int depth){
        maxDepth = Math.max(maxDepth, depth);

        if(nTree[root].leftChild != -1)
            inOrder(nTree[root].leftChild, depth + 1);
        levelMin[depth] = Math.min(levelMin[depth], curIdx);
        levelMax[depth] = curIdx++;

        if(nTree[root].rightChild != -1)
            inOrder(nTree[root].rightChild, depth + 1);
    }

}
