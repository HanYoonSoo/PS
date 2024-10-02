import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            String binaryNum = Long.toBinaryString(numbers[i]);
            
            int power = 0;
            
            while(Math.pow(2, power) - 1 < binaryNum.length()){
                power++;
            }
            
            int addZero = (int)((Math.pow(2, power) - 1) - binaryNum.length());
            
            String binaryTree = "0".repeat(addZero).concat(binaryNum);
            
            if(isBinaryTree(binaryTree)){
                result[i] = 1;
            } else{
                result[i] = 0;
            }
        }
        
        return result;
    }
    
    public boolean isBinaryTree(String binaryTree){
        int root = binaryTree.length() / 2;
        String leftTree = binaryTree.substring(0, root);
        String rightTree = binaryTree.substring(root + 1, binaryTree.length());
        
        if(leftTree.length() > 0 && rightTree.length() > 0){
            boolean leftZero = leftTree.charAt(leftTree.length() / 2) == '0';
            boolean rightZero = rightTree.charAt(rightTree.length() / 2) == '0';
            
            if(binaryTree.charAt(root) == '0' && (!leftZero || !rightZero)){
                return false;
            }
        }
        
        boolean compare = true;
        
        if(leftTree.length() >= 3){
            compare = isBinaryTree(leftTree);
            if(compare){
                compare = isBinaryTree(rightTree);
            }
        }
        
        return compare;
    }
}