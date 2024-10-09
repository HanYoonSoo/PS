import java.util.*;

class Solution {
    class Node{
        int x;
        int y;
        int idx;
        Node left;
        Node right;
        
        public Node(int x, int y, int idx, Node left, Node right){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }
    
    int[][] result;
    int[] resultPre;
    int[] resultPos;
    int idx;
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
           
            return o2.y - o1.y;
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i < nodeinfo.length; i++){
            insert(root, nodes[i]);    
        }
        
        result = new int[2][nodeinfo.length];
        resultPre = new int[nodeinfo.length];
        resultPos = new int[nodeinfo.length];
        
        idx = 0;
        preorder(root);
        result[0] = resultPre;
        
        idx = 0;
        postorder(root);
        result[1] = resultPos;
        
        return result;
    }
    
    public void insert(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            } else{
                insert(parent.left, child);
            }
        } else{
            if(parent.right == null){
                parent.right = child;
            } else{
                insert(parent.right, child);
            }
        }
    }
    
    public void preorder(Node parent){
        // System.out.println(parent.idx);
        resultPre[idx++] = parent.idx;
        
        if(parent.left != null){
            preorder(parent.left);
        }
        
        if(parent.right != null){
            preorder(parent.right);
        }
    }
    
    public void postorder(Node parent){
        if(parent.left != null){
            postorder(parent.left);
        }
        
        if(parent.right != null){
            postorder(parent.right);
        }
        
        resultPos[idx++] = parent.idx;
    }
}