import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void insert(int value){
            if(value < this.value){
                if(this.left == null){
                    this.left = new Node(value);
                } else{
                    this.left.insert(value);
                }
            } else{
                if(this.right == null){
                    this.right = new Node(value);
                } else{
                    this.right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root;

        root = new Node(Integer.parseInt(br.readLine()));

        String num;

        while (true) {
            num = br.readLine();
            if (num == null || num.equals(""))
                break;
            root.insert(Integer.parseInt(num));
        }


        postOrder(root);
    }

    public static void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        System.out.println(node.value);
    }
}
